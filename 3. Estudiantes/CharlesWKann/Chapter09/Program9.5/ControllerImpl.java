/** TITLE: Program 9.5e
 *
 * @(#)ControllerImpl.java 2002/07/21
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

/**
 *    Purpose: This is a controller object that is used with the animator.  This is 
 *             probably the most generic type of interface that can be implement.  It
 *             does not implement a GUI to be used, but the monitor objec that can be
 *             used, and can be used with any one of a number of GUI's.
 */


public class ControllerImpl implements Controller {
    // States for this monitor.
    private static final int WAITING = 0;
    private static final int MOVING = 1;
    private static final int DRAWING = 2;
    private static final int STOPPED = 3;

    private int controllerState = STOPPED;
    private int stateAfterDoRedraw = WAITING;
    
    /***************/

    private int waitTime = 100;  // Time to wait between drawing.

    private Animator animator;  // animator to be used with this controller.

    /**
     *  public constructor.  This just hooks this controller up to the animator.
     */
    public ControllerImpl(Animator animator) {
        this.animator = animator;
    }

    /**
     *  this method is called by the animator's paint method to reset this controller 
     *  object, and to return to the animator whether or not the event that caused
     *  this repaint was from the animator or some other event, such as a reSize event.
     *  Because it is run from the GUI thread, it cannot do a wait in the method.
     */
    public synchronized boolean doRedraw() {
        boolean returnValue;

        if (controllerState == DRAWING)
            returnValue = true;
        else
            returnValue = false;

        if (controllerState == DRAWING) {
            controllerState = stateAfterDoRedraw;
            notifyAll();
        }
        
        return returnValue;
    }

    /**
     *  This method is called from the GUI's controller thread to do the wait
     *  for the amount of time between redraws.  Because it cannot run in the GUI
     *  thread, it can execute a wait inside of the method.
     */
    public synchronized void doWait() {
        try {
            while ( ! (controllerState == WAITING)) {
                wait();
            }

            controllerState = MOVING;
            notifyAll();

            wait(waitTime);  // post processing.  This hangs the controller
                             // thread for waitTime, but also allows any
                             // notify to get it to start.
        } catch(InterruptedException e) {
        }
    }

    /**
     *  This method is called from the GUI's controller thread to signal the thread is
     *  is doing a move.
     */
    public synchronized void doMove() {
        try {
            while ( ! ((controllerState == MOVING) ||
                   (controllerState == WAITING))) {
                wait();
            }
            
            stateAfterDoRedraw = WAITING;
            animator.repaint();

            if (controllerState == MOVING) {
                controllerState = DRAWING;
                notifyAll();
            }

        } catch(InterruptedException e) {
        }
    }

    /** 
     *  Called from the Controller GUI to stop the animator.  Because it runs in the
     *  thread, wait cannot be called from this method.  Also when a button is pressed,
     *  the controller notifies all waiting threads (which is only the GUI controller thread).
     */
    public synchronized void doStop() {
        stateAfterDoRedraw = STOPPED;
        controllerState = STOPPED;
        notifyAll();
    }

    /** 
     *  Called from the Controller GUI to start the animator.  Because it runs in the
     *  thread, wait cannot be called from this method.  Also when a button is pressed,
     *  the controller notifies all waiting threads (which is only the GUI controller thread).
     */
    public synchronized void doStart() {
        stateAfterDoRedraw = WAITING;
        animator.repaint();
        controllerState = DRAWING;
        notifyAll();
    }

    /** 
     *  Called from the Controller GUI to step the animator.  Because it runs in the
     *  thread, wait cannot be called from this method.  Also when a button is pressed,
     *  the controller notifies all waiting threads (which is only the GUI controller thread).
     */
    public synchronized void doStep() {
        stateAfterDoRedraw = STOPPED;
        animator.repaint();
        controllerState = DRAWING;
        notifyAll();
    }

    public synchronized void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
        notifyAll();
    }
}

