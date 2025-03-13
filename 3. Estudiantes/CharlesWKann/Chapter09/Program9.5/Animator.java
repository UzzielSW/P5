/** TITLE: Program 9.5g
 *
 * @(#)Animator.java 2002/07/21
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
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 *    Purpose: The animator is simply a Java Event Model.  Objects that want to be drawn
 *             register themselves with the animator.  When a repaint event is generated
 *             the paint method is called, and that method calls the controller's
 *             doRedraw method and then calls the draw method in each object that is 
 *             registered.
 * 
 *             Note that the animator is designed as components that can be combined
 *             together to produce an animator.  There is one example of putting these
 *             pieces together in the method createAnimator method.
 */

public class Animator extends JPanel {

    private Vector elementsToDraw = new Vector();
    private Controller controller;

    /**
     *  A static method to create an instance of the Animator using a frame for the
     *  animator and a frame for the controller.
     */
    public static Animator createAnimator() {
        Animator animator = new Animator();
        JFrame animFrame = new JFrame("Generic Aniamtor");
        Container animContainer = animFrame.getContentPane();
        animContainer.add(animator);
        animFrame.setSize(700,450);
        animFrame.setLocation(0,100);
        animFrame.setVisible(true);

        ControllerImpl controllerImpl = new ControllerImpl(animator);
        animator.setController(controllerImpl);
        ControlPanel controlPanel = new ControlPanel(controllerImpl);
        JFrame controlFrame = new JFrame("Control Panel");
        Container controlContainer = controlFrame.getContentPane();
        controlContainer.add(controlPanel);
        controlFrame.setSize(500,100);
        controlFrame.setVisible(true);

        try {
            controlPanel.startControlPanel();
        } catch (ControllerAlreadyStartedException e) {
        }


        return animator;
    }

    /**
     *  public constructor.  If this constructor is used the controller must be set
     *  at some point using the setController method.
     */
    public Animator() {
    }

    /**
     *  public constructor.  This constructor hooks the animator to a controller.
     */
    public Animator(Controller controller) {
        this.controller = controller;
    }

    /**
     *  Accessor method that sets the controller for this object.
     */
    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     *  this method implements the equivalent of the processEvent method for the
     *  Java Event Model.
     */
    public void paint(Graphics g) {
        DrawEvent de;
        super.paint(g);

        if ((controller != null) && (!controller.doRedraw()))
            de = new DrawEvent(this, g, false);
        else
            de = new DrawEvent(this, g, true);

        Vector v;
        synchronized(this) {
             v = (Vector) elementsToDraw.clone();    
        }

        Enumeration e = v.elements();
        while (e.hasMoreElements())
            ((DrawListener) e.nextElement()).draw(de);
    } 

    /** 
     *  the addListener method for the Java Event Model.
     */
    public synchronized void addDrawListener(DrawListener d) {
        elementsToDraw.addElement(d);
    }

    /** 
     *  the removeListener method for the Java Event Model.
     */
    public synchronized void removeDrawListener(DrawListener d) {
        elementsToDraw.removeElement(d);
    }

}
