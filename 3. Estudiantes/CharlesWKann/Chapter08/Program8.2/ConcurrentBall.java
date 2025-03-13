/*
 * TITLE: Program 8.2
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
 *  Purpose:    This class shows a second simple, but invalid, 
 *		way to use the Animator Component from Chapter 7 
 *		to animate a concurrent program.  In order to 
 *		handle the problem of no coordination between the
 *		ball thread and the GUI thread, the program has
 *		put a wait in the run method to stop the thread
 *		until the path is finished drawing.  This wait
 *		call is matched with a notifyAll in call in
 *		the draw method which wakes the thread.  The 
 *		problem is that the run method is completely 
 *		synchronized, and so while it is sleeping it
 *		holds the synchronized lock on the ball object.
 *		This prevents the GUI thread from running in
 *		in the draw method until both waits are called
 *		on both objects in the animation.  This makes
 *		the balls move together, and also makes the
 *		control panel behave poorly.
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
 *		    3 - Call sleep to sleep a random amount of 
 *			time before moving again.
 *		
 *		In the draw method:
 *		    1 - draw the ball at the right position. 
 *		    2 - If the path is done, wake up the ball 
 *			thread.
 *
 *		This program fails because the run method is
 *		completely synchronized, and so the GUI thread
 *		cannot run while either thread sleeps.
 */

import java.awt.*;
import java.util.*;
import animator.*;

/**
 *   This class animates a ball in a thread using the Animator 
 *   Component, but fails because the run method is 
 *   completely synchronized.
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
     *  The myPath variable is set here and used in the
     *  draw method, and is intended to coordinate the
     *  ball thread running in this method, and the GUI
     *  thread (from the animator) running in the draw
     *  method.  But the complete syncrhonization of 
     *  method forces the GUI thread to suspend while
     *  it sleeps.
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
            wait();
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
