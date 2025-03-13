/*
 * TITLE: Program 10.6b
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

import java.util.Random;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import animator.*;

/*
 *  Purpose: This program shows how to use the Classification
 *           designed version of the animator that tries to 
 *           mimic encapsulation to implement
 *           the move method.  This classification version tries
 *           to implement the same encapsulation construction
 *           as in the composition design, and since 
 *           this class extends the MoveController the calls to
 *           the moveController do not have to be prefaced by
 *           the "mc" variable as in Program 10.5b.  This 
 *           ability to not have to preface the methods with
 *           the object's identifier can be viewed as a small
 *           plus.  It can also result in confusion as to 
 *           what method is really called if the method exists
 *           several places in the hierachy.
 */

public class ConcurrentBall extends MoveController
                            implements DrawListener, Runnable {

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
     *  Draw is called each time through the animator loop to draw the
     *  object. It simply uses the path to calculate the position 
     *  of this object, and then draws itself at that position.
     *  When the end of the path is reached, it notifies the ball
     *  thread.
     */
    public synchronized void draw(DrawEvent de) {
        Point p = nextPosition();
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
        
        ConcurrentBall cb1 = new ConcurrentBall(animator);
        (new Thread(cb1)).start();

        animator.setVisible(true);
    }
}
