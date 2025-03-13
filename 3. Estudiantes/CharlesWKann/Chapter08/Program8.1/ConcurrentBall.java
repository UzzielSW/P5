/*
 * TITLE: Program 8.1
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
 *  Purpose:    This class shows a simple, but invalid, way to use the
 *		Animator Component from Chapter 7 to animate a concurrent
 *		program.  The problem here is that the movement of
 *		the ball in the animator through a path can take 
 *		longer than the sleep time for the thread running it.
 *		This results in the ball "jumping" to a side when the
 *		path is created.  To see this, pull the animatiron 
 *		scrollbar all the way to the left when the program is 
 *		running.
 *
 *  Procedure:	Start the animator, and create a ball object that is
 *		a thread.  In the run method of the thread, add the
 *		ball to the animator.  The animation is intended to
 *		to be run as follows:
 *		    1 - The ball moves from one side of the screen
 *			to the other.
 *		    2 - The ball then sleeps for a random amount
 *			of time.
 *		Note that the path is created in the ball thread, 
 *		in the run method, and then walked in the GUI thread
 *		in the draw method.  
 *
 *		This program fails because the ball thread and the
 *		GUI thread are not coordinated. 
 */

import java.awt.*;
import java.util.*;
import animator.*;

/**
 *   This class animates a ball in a thread using the Animator 
 *   Component, but fails because the thread is not coordinated 
 *   with the GUI thread calling the draw method.
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
        this.direction = direction;
        random = new Random(direction);
        this.animator = animator;
    }

    /**
     *  run method, which simulates an asynchronous ball.
     *  The myPath variable is set here and used in the
     *  draw method, and is intended to coordinate the
     *  ball thread running in this method, and the GUI
     *  thread (from the animator) running in the draw
     *  method.  But no coordination is in place, and this
     *  fails.
     */
    public void run() { 
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
            Thread.sleep(random.nextInt(10000));
            }
        } catch (InterruptedException e) {
        }
    }

    /** 
     *  Draw is called each time through the animator loop to draw the
     *  object. It simply uses the path to calculate the position 
     *  of this object, and then draws itself at that position.
     */

    public void draw(DrawEvent de) {
        Point p = myPath.nextPosition();
        Graphics g = de.getGraphics();
        g.setColor(Color.red);
        g.fillOval((int)p.getX(), (int)p.getY(), 15, 15);
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
