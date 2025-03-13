/** TITLE: Program 9.5f
 *
 * @(#)ControlPanel.java 2002/07/21
 * @author Charles W. Kann III
 *
 * Copyright (c) 2002 CRC Press
 * All Rights Reserved.
 *
 * Permission to use, copy, modify, and distribute this
 * software and its documentation for NON-COMMERCIAL purposes
 * and without fee is hereby granted provided that this
 * copyright notice appears in all copies.
 *
 * THE AUTHOR MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE
 * SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR
 * NON-INFRINGEMENT. THE AUTHOR SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 *    Purpose: This object creates a control panel, which is a type of JPanel, that will
 *             interface with the ControllerImpl object to control the animator.  It also
 *             kicks off a GUI controller thread which is where the controller sleeps so 
 *             that it does not suspend the GUI thread.
 */

public class ControlPanel extends JPanel {
    private ControllerImpl controllerImpl;
    private boolean controllerStarted = false;

    /**
     *  public constructor.  This constructor hooks to the ControllerImp to control
     *  and then creates the panel with all the controls to run the animator.
     */
    public ControlPanel(ControllerImpl controllerImpl) {
        this.controllerImpl = controllerImpl;
        createPanel();
    }

    /**
     *  this method creates all the controls for the animator, and hooks all the actions
     *  to the controls.
     */
    private void createPanel() {
        setLayout(new FlowLayout());

        final JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton jb = (JButton)(e.getSource());
                String s = jb.getText();
                if (s.equals("Start")) {
                    controllerImpl.doStart();
                    startButton.setText("Stop");
                }
                else {
                    controllerImpl.doStop();
                    startButton.setText("Start");
                }
            }
        });
        add(startButton);

        final JButton stepButton = new JButton("Step");
        stepButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controllerImpl.doStep();
                startButton.setText("Start");
            }
        });
        add(stepButton);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);

        add(new Label("Animator Speed"));
        final JScrollBar speedControl = new JScrollBar(JScrollBar.HORIZONTAL,
                500, 25, 100, 1000);
        speedControl.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                controllerImpl.setWaitTime(1000 - e.getValue());
            }
        });
        add(speedControl);
    }

    /**
     *  Display the control panel.  Note that if by this time the control
     *  panel is not associated with an animator, it is a mistake.  Throw
     *  an exception if this happens.
     */

    public void startControlPanel() throws ControllerAlreadyStartedException {

        if (controllerStarted) {
            throw new ControllerAlreadyStartedException();
        }

        setVisible(true);
        controllerStarted = true;
        (new Thread(new ControlThread())).start();
    }

    /** Thread that runs the animator.  This thread sleeps for some amount of time specified by sleepTime, 
    *   then calls repaint which forces a call to the paint method, but in the GUI thread.
    *   Note that the animatorStopped button allows the animator to single step and pause the animation.  The
    *   notify is done in the control frame from the button.
    */

    private class ControlThread implements Runnable {
        public void run() {
            while (true) {
                controllerImpl.doWait();
                controllerImpl.doMove();
            }
        }
    }
}
