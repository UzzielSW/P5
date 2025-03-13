/*
 * TITLE: Program 7.5
 *
 * @(#)MoveObjects 2002/07/21
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

/**
 *  Purpose: 	This class uses the animator to create
 *		an animator object and MoveBall and 
 *		MoveRect objects, and registers them 
 *		with the animator, creating an animation.
 */

public class MoveObjects {

    public static void main(String args[]) {
        Animator animator = new Animator();
        MoveBall mb = new MoveBall(MoveBall.UP, 1);
        animator.addDrawListener(mb);
        MoveRect mr = new MoveRect(MoveRect.DOWN, 2);
        animator.addDrawListener(mr);
        animator.setVisible(true);
    }
}

//  Two classes, MoveBall and MoveRect, almost exactly the same.
//  The constuctor adds them to the animator, and the draw
//  handles the Path to move them and the drawing of them.
//

class MoveBall implements DrawListener {

    static final int UP = 1;
    static final int DOWN = 0;
    private int direction = DOWN;

    private Path myPath;
    private Point myPosition = new Point(10,10);
    private int myNumber;


    /** Constructor - Simply register myself with the animator.
    */
    public MoveBall(int direction, int myNumber) {
        this.direction = direction;
        this.myNumber = myNumber;
    }

    /** Draw is called each time through the animator loop to draw the
    *   object. It simply
    *   uses the path to calculate the position of this object, and then
    *   draws itself at that position.
    */
    public void draw(DrawEvent de) {
        Graphics g = de.getGraphics();
        if (myPath != null && myPath.hasMoreSteps())
            myPosition = myPath.nextPosition();
        else {
            // Get a random number of steps to make the balls move
            // at different speeds.  Note there has to be at least
            // 1 step in each path, but for appearances we used at least
            // 10 steps.
            int numberOfSteps = (int) (10.0 + (Math.random() * 100.0));

            if (direction == DOWN) {
                myPath = new StraightLinePath(410, 410, 10, 10, numberOfSteps);
                myPosition = myPath.nextPosition();
                direction = UP;
            }
            else {
                myPath = new StraightLinePath(10, 10, 410, 410, numberOfSteps);
                myPosition = myPath.nextPosition();
                direction = DOWN;
            }
        }
        g.setColor(Color.RED);
        g.fillOval((int)myPosition.getX(), (int)myPosition.getY(), 15, 15);
        g.setColor(Color.BLACK);
        g.drawString("" + myNumber,
            (int)myPosition.getX()+3, (int)myPosition.getY()+12);
    }
}

class MoveRect implements DrawListener {

    static final int UP = 1;
    static final int DOWN = 0;
    private int direction = DOWN;

    private Path myPath;
    private Point myPosition = new Point(10,10);
    private int myNumber;


    /** Constructor - Simply register myself with the animator.
    */
    public MoveRect(int direction, int myNumber) {
        this.direction = direction;
        this.myNumber = myNumber;
    }

    /** Draw is called each time through the animator loop to draw the
    *   object. It simply
    *   uses the path to calculate the position of this object, and then
    *   draws itself at that position.
    */
    public void draw(DrawEvent de) {
        Graphics g = de.getGraphics();
        if (myPath != null && myPath.hasMoreSteps())
            myPosition = myPath.nextPosition();
        else {
            // Get a random number of steps to make the balls move
            // at different speeds.  Note there has to be at least
            // 1 step in each path, but for appearances we used at least
            // 10 steps.
            int numberOfSteps = (int) (10.0 + (Math.random() * 100.0));

            if (direction == DOWN) {
                myPath = new StraightLinePath(410, 410, 10, 10, numberOfSteps);
                myPosition = myPath.nextPosition();
                direction = UP;
            }
            else {
                myPath = new StraightLinePath(10, 10, 410, 410, numberOfSteps);
                myPosition = myPath.nextPosition();
                direction = DOWN;
            }
        }
        g.setColor(Color.YELLOW);
        g.fillRect((int)myPosition.getX(), (int)myPosition.getY(), 15, 15);
        g.setColor(Color.BLACK);
        g.drawString("" + myNumber,
            (int)myPosition.getX()+3, (int)myPosition.getY()+12);
    }
}

