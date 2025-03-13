/*
 * TITLE: Program 8.3
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

/*
 *  Purpose:    This class shows a valid, but potentially 
 *		dangerous,way to use the Animator Component 
 *		from Chapter 7 to animate a concurrent program.  
 *		In order to handle the problem of the GUI
 *		thread being unable to execute while the ball
 *		thread is sleeping, a wait(int) call is used
 * 		rather than a sleep(int) call.  Because there
 *		can be no notify or notifyAll calls when this
 *		call is waiting, it is just like a sleep call
 *		except that it drops the syncrhonized lock,
 *		allowing the GUI thread to continue to run.
 *
 *  Procedure:	Start the animator, and create a ball object that is
 *		a thread.  In the run method of the thread, add the
 *		ball to the animator.  The animation is intended to
 *		to be run as follows:
 *		    1 - The ball moves from one side of the screen
 *			to the other.
 *		    2 - The ball then sleeps for a random amount
 *			of time.
 *		This behavior is to be acccomplished by the 
 *		following mechanism.  
 *		
 *		In the run method:
 *		    1 - Create the path the object is to move in.
 *			This will be used in the draw method to 
 *			move the object.
 *		    2 - Call wait to have this thread wait for the
 *			ball to finish moving.
 *		    3 - Call wait(int) to sleep a random amount of 
 *			time before moving again.  This call also
 *			drops the synchronized lock on the object.
 *		
 *		In the draw method:
 *		    1 - draw the ball at the right position. 
 *		    2 - If the path is done, wake up the ball 
 *			thread.
 *
 *		This program works, but the use of a wait(int)
 *		call is potentially unsafe.
 */

import java.awt.*;
import java.util.*;
import animator.*;

/**
 *   This class animates a ball in a thread using the Animator 
 *   Component, using a wait(int) call instead of sleep so 
 *   that the object lock is dropped while the component
 *   is sleeping.
 */
public class ConcurrentBall implements DrawListener, Runnable {

    static final int EAST = 0;
    static final int WEST = 1;
    static final int NORTH = 2;
    static final int SOUTH = 3;
    int direction;

    boolean pleaseNotify = false;
    Path myPath;
    Random random;
    Animator animator;


    /** 
     *   Constructor.  Just save information for this ball.
     */
    public ConcurrentBall(Animator animator, int direction) {
        this.direction = direction;
        this.animator = animator;
        random = new Random(direction);
    }

    /**
     *  run method, which simulates an asynchronous ball.
     *  The myPath variable is set here and used in the
     *  draw method, and is intended to coordinate the
     *  ball thread running in this method, and the GUI
     *  thread (from the animator) running in the draw
     *  method.  This works, but uses wait(int) which
     *  drops the object lock.
     */

    public synchronized void run() { 
        animator.addDrawListener(this);
        try {
            while(true) {
                if (direction == SOUTH) {
                    myPath = new StraightLinePath(410, 205, 10, 205, 50);
                    direction = NORTH;
                }
                else if (direction == NORTH) {
                    myPath = new StraightLinePath(10, 205, 410, 205, 50);
                    direction = SOUTH;
                }
                else if (direction == EAST) {
                    myPath = new StraightLinePath(205, 410, 205, 10, 50);
                    direction = WEST;
                }
                else if (direction == WEST) {
                    myPath = new StraightLinePath(205, 10, 205, 410, 50);
                    direction = EAST;
                }
            pleaseNotify = true;
            wait();
            pleaseNotify = false;
            wait(random.nextInt(10000));
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

        // Do not notify if the wait is for the wait that
        // emulates the sleep.
        if ((! myPath.hasMoreSteps()) && pleaseNotify) {
            notify();
        }
    }

    /**
     *  main method.  This just creates the animator and the
     *  ball threads, and starts them running.
     */
    public static void main(String args[]) {
        Animator animator = new Animator();
        
        ConcurrentBall cb1 = new ConcurrentBall(animator, WEST);
        (new Thread(cb1)).start();

        ConcurrentBall cb2 = new ConcurrentBall(animator, NORTH);
        (new Thread(cb2)).start();

        animator.setVisible(true);
    }
}
