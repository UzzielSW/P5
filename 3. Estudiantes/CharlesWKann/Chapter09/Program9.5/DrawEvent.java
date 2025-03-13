/** TITLE: Program 9.5a
 *
 * @(#)DrawEvent.java 2002/07/21
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

import java.util.*;
import java.awt.*;
import java.io.Serializable;

/**
 *    Purpose: This is the Event State Object for the Chapter 9 animator.  Note
 *             that this event includes the Graphics object, and also a flag (doMove)
 *             that indicates to the application whether the redraw was a result of
 *             the animator creating a new event indicating the animation should continue,
 *             or some other source, such as a reSize method call.
 */

public class DrawEvent extends EventObject implements Serializable {
    Graphics myGraphics;
    boolean doMove;

    /**
     *  public constructor that takes all the possible options needed for this event.
     */
    public DrawEvent(Object source, Graphics graphics, boolean doMove) {
        super(source);
        myGraphics = graphics;
        doMove = doMove;
    }

    /**
     *  public constructor that sets the doMove variable to the default value of true.
     */
    public DrawEvent(Object source, Graphics graphics) {
        this(source, graphics, true);
    }

    /**
     *  accessor method to return the value of the myGraphics variable.
     */
    public Graphics getGraphics() {
        return myGraphics;
    }

    /**
     *  accessor method to return the value of the doMove variable.
     */
    public boolean getDoMove() {
        return doMove;
    }
}
