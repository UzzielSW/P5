/*
 * TITLE: Program 10.1
 *
 * @(#)ConcurrentBall 2002/07/21
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
import java.util.*;
import animator.*;

/**
 *   Purpose: This class animates a ball in a thread using the Animator 
 *   Component, but the cooperative synchronization is implemented
 *   by copying a block of code twice in the run method.
 */

public class ConcurrentBall implements DrawListener, Runnable {

    private Path myPath;
    private Animator animator;

    /** Constructor.  Note that we need to register with the animator
    *   through the run method.
    */
    public ConcurrentBall(Animator animator) {
        this.animator = animator;
    }

    /**
     *  run method, which simulates an asynchronous ball.
     *  The myPath variable is set here and used in the
     *  draw method, and is intended to coordinate the
     *  ball thread running in this method, and the GUI
     *  thread (from the animator) running in the draw
     *  method.  This works correctly.
     */
    public void run() { 
 
       // Set an initial point to draw this object, and then add it
       // to the animator.
       myPath = new StraightLinePath(10, 205, 10, 205, 1);
       animator.addDrawListener(this);
       Random random = new Random(System.currentTimeMillis());
 
       try {
            // Note this block of code is copied twice in this 
            // program.  All that is changed is the actual path
            // that is created.  It would be best to abstract
            // out this behavior.
            while(true) {
                 synchronized(this) {
                    try {
                        myPath = new StraightLinePath(410, 205, 10, 205, 50);
                        wait();
                   } catch(InterruptedException e) {
                   }
                }
                Thread.sleep(random.nextInt(10000));

                synchronized(this) {
                    try {
                        myPath = new StraightLinePath(10, 205, 410, 205, 50);
                        wait();
                    } catch(InterruptedException e) {
                    }
                }
                Thread.sleep(random.nextInt(10000));
            }
        } catch (InterruptedException e) {
        }
    }

    /** 
     *  Draw is called each time through the animator loop to draw the
     *  object. It simply uses the path to calculate the position 
     *  of this object, and then draws itself at that position.
     *  When the end of the path is reached, it notifies the ball
     *  thread.
     */
    public synchronized void draw(DrawEvent de) {
        Point p = myPath.nextPosition();
        Graphics g = de.getGraphics();
        g.setColor(Color.red);
        g.fillOval((int)p.getX(), (int)p.getY(), 15, 15);

        if (! myPath.hasMoreSteps())
            notify();
    }

    /**
     *  main method.  This just creates the animator and the
     *  ball threads, and starts them running.
     */
    public static void main(String args[]) {
        Animator animator = new Animator();
        
        ConcurrentBall cb1 = new ConcurrentBall(animator);
        (new Thread(cb1)).start();
        animator.setVisible(true);
    }
}
