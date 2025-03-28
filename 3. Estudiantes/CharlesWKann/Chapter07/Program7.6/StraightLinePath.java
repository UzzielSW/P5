/*
 * TITLE: Program 7.1a
 *
 * @(#)StraightLinePath 2002/07/21
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

import java.awt.Point;

/**
 *  Purpose:    The StraightLinePath class defines a starting position, stopping
 *              position, and number of steps.  It then calculates the
 *              next position that occurs along the path.  It is
 *		first used in Program 7.1, but is used in all the 
 *		animation examples, and is an essential part to the 
 *		final aniamtor.
 *		
 *		Note that in this case it is a simple straight line, 
 *		but the path could be a spline curve, or Bessel 
 *		function, etc.
 */

public class StraightLinePath implements Path {
    int startX, startY, endX, endY, steps;
    int currentStep = -1;      // This makes the first step 0
    double deltaX, deltaY;

    /** Constructor Stores the points, and builds the information
     *  needed to construct the next point.  Note that for a path we
     *  need the initial point for the path (X1, Y1), the final point
     *  for the path (X2, Y2), and the number of steps in the path (
     *  numSteps).
     */
    public StraightLinePath(int X1, int Y1, int X2, int Y2, int numSteps) {
        startX = X1;
        startY = Y1;
        endX = X2;
        endY = Y2;
        steps = numSteps;
        deltaX = ((double)(X2 - X1)) / steps;
        deltaY = ((double)(Y2 - Y1)) / steps;
    }

    /** 
     *  Check to see if the path has MoreSteps
     */
    public boolean hasMoreSteps() {
        if (currentStep > steps)
            return false;
        return true;
    }

    /** 
     *  Get the next position.  If the path has no more steps, return
     *  the current position.
     */
    public Point nextPosition() {
        currentStep++;
        if (currentStep > steps)
            return new Point(endX, endY);
        return new Point((int)(startX + (deltaX * currentStep)),
                (int)(startY + (deltaY * currentStep)));
    }
}

