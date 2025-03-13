/*
 * TITLE: Program 10.5b
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

import java.awt.Graphics;
import java.awt.Point;
import animator.*;

/*
 *  Purpose:    This class implements the MoveController using
 *		classification.  Any class wishing to use this 
 *		class must extend it.
 *
 *        	Note that this design is attempting to mimic the
 *		encapsulation in the composition design.  To do
 *		this all the variables are made private and all
 *		the methods made protected.  This appears to 
 *		be a valid solution, but as the comment in the
 *		move method shows, the object's lock is still
 *		shared, which can lead to problems.
 */

abstract public class MoveController {
    private Path myPath;
    private boolean doNotify = false;
    private Object notifyObject = new Object();

    protected void move(Path path) {
        synchronized(notifyObject) {
            myPath = path;
            try {
                doNotify = true;
                notifyObject.wait();
            } catch (InterruptedException e) {
            }
        }
    }

    protected boolean hasMoreSteps() {
        return myPath.hasMoreSteps();
    }

    protected Point nextPosition() {
        if (myPath != null && myPath.hasMoreSteps()) {
            return myPath.nextPosition();
        }
        else if (myPath != null) {
            if (doNotify) {
                synchronized(notifyObject) {
                    doNotify = false;
                    notifyObject.notify();
                }
            }
            return myPath.nextPosition();
        }
        else
            return new Point(0,0);
    }
}
