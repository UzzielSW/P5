/*
 * TITLE: Program 10.3
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

/*
 *  Purpose:    This class shows that method reuse cannot be
 *              extended to other classes when the method requires
 *              that state be maintained between invocations.  In
 *              this case, the move method must be repeated in the
 *              Ball and Square classes because of the dependency 
 *              on the myPath variable and the Synchronized lock.
 *
 */

public class MoveObjects  {
    /**
     *  main method.  This just creates the animator and the
     *  ball threads, and starts them running.
     */
    public static void main(String args[]) {
        Animator animator = new Animator();
        
        (new Thread(new Ball(animator))).start();
        (new Thread(new Square(animator))).start();
        animator.setVisible(true);
    }
}

class Ball implements DrawListener, Runnable {

    private Path myPath;
    private Animator animator;

    /** Constructor.  Note that we need to register with the animator
    *   through the run method.
    */
    public Ball(Animator animator) {
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
            while(true) {
                move(new StraightLinePath(410, 205, 10, 205, 50));
                Thread.sleep(random.nextInt(10000));

                move(new StraightLinePath(10, 205, 410, 205, 50));
                Thread.sleep(random.nextInt(10000));
            } 
        } catch (InterruptedException e) {
        }
    }

    /** 
     *  This method allows a thread to move to completion 
     *  before it continues.  A Path variable is defined
     *  and then a wait done.  This wait is matched by a
     *  notify in the draw method when this thread has
     *  reached the end of the path, releasing the thread
     *  to continue running.
     */
    public synchronized void move(Path path) {
        myPath = path;
        try {
            wait();
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
}

class Square implements DrawListener, Runnable {

    private Path myPath;
    private Animator animator;

    /** Constructor.  Note that we need to register with the animator
    *   through the run method.
    */
    public Square(Animator animator) {
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
            while(true) {
                move(new StraightLinePath(10, 205, 410, 205, 50));
                Thread.sleep(random.nextInt(10000));

                move(new StraightLinePath(410, 205, 10, 205, 50));
                Thread.sleep(random.nextInt(10000));
            } 
        } catch (InterruptedException e) {
        }
    }

    /** 
     *  This method allows a thread to move to completion 
     *  before it continues.  A Path variable is defined
     *  and then a wait done.  This wait is matched by a
     *  notify in the draw method when this thread has
     *  reached the end of the path, releasing the thread
     *  to continue running.
     */
    public synchronized void move(Path path) {
        myPath = path;
        try {
            wait();
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
        g.fillRect((int)p.getX(), (int)p.getY(), 15, 15);

        if (! myPath.hasMoreSteps())
            notify();
    }

}
