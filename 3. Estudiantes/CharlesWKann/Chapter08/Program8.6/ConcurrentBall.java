/*
 * TITLE: Program 8.6
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
 *  Purpose:    This class shows how to implement a notification
 *		object.  While a notification object is a much
 *		more powerful mechanism than is needed here, 
 *		it is easy to explain in this context, especially
 *		after having used this program through many 
 *		examples.  It will be used in Chapter 9 for 
 *		situations that cannot be handle effectively using
 *		simpler means.
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
 *		    1 - Create the temporary path the object 
 *			for the notification object.  This path
 *			is also the way the object is to move.
 *			This will be used in the draw method to 
 *			move the object, and to notify the
 *			specific ball thread.
 *		    2 - Lock on the temporary path object.
 *			This prevents the notify from occuring
 *			before the wait.
 *		    3 - Lock on the "this" object to prevent
 *			the draw method from being called.
 *		    4 - Give the temporary path object scope by
 *			setting the instance variable myPath to
 *			this object.
 *		    5 - Drop the lock on the "this" object.  Now
 *			the draw method can be entered, but it 
 *			cannot do the notify because it cannot
 *			yet obtain the lock on the myPath object.
 *		    6 - Call wait on mypath to have this thread 
 *			wait for the ball to finish moving.
 *		    7 - Call sleep to sleep a random amount of 
 *			time before moving again.
 *		
 *		In the draw method:
 *		    1 - Get the lock on the "this" object.
 *		    2 - draw the ball at the right position. 
 *		    3 - If the path is done, wake up the ball 
 *			thread.
 *			3a - Get the lock on the myPath object.
 *			3b - Notify on the myPath object.
 *
 *		This program works and shows how to implement a
 *		notification object.
 */

import java.awt.*;
import java.util.*;
import animator.*;

/**
 *   This class animates a ball in a thread using the Animator 
 *   Component. It shows how a Notification Object can be used
 *   to implement a correct coordination between the GUI and
 *   ball threads.
 */

public class ConcurrentBall implements DrawListener, Runnable {

    static final int EAST = 0;
    static final int WEST = 1;
    static final int NORTH = 2;
    static final int SOUTH = 3;
    int direction;

    Path myPath;
    Random random;
    Animator animator;

    /** 
     *   Constructor.  Just save information for this ball.
     */
    public ConcurrentBall(Animator animator, int direction) {
        this.animator = animator;
        this.direction = direction;
        random = new Random(direction);
    }

    /**
     *  run method, which simulates an asynchronous ball.
     *  The coordination is via a notification object,
     *  which is explained in this functions header.
     */
    public void run() { 
        Path tempPath;   // Local variable to set to myPath.  Used as
                         // part of notification object
        animator.addDrawListener(this);
        try {
            while(true) {
                if (direction == SOUTH) {
                    tempPath = new StraightLinePath(410, 205, 10, 205, 50);
                    direction = NORTH;
                }
                else if (direction == NORTH) {
                    tempPath = new StraightLinePath(10, 205, 410, 205, 50);
                    direction = SOUTH;
                }
                else if (direction == EAST) {
                    tempPath = new StraightLinePath(205, 410, 205, 10, 50);
                    direction = WEST;
                }
                else { //direction == WEST
                    tempPath = new StraightLinePath(205, 10, 205, 410, 50);
                    direction = EAST;
                }

                synchronized(tempPath) {
                    synchronized (this) {
                        myPath = tempPath;
                    }
                    myPath.wait();
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

        if (! myPath.hasMoreSteps()) {
            synchronized(myPath) {
                myPath.notify();
            }
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
