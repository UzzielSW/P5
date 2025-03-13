/*
 * TITLE: Program 10.4a
 *
 * @(#)MoveController 2002/07/21
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
 *  Purpose: This class implements the MoveController
 *           using classification.  The class which wants 
 *           to use this object must extend the MoveController 
 *           class, and it must complete the cooperative 
 *           synchronization	by calling the check notify in 
 *           its draw method.
 *		
 *           Note that any class which uses this also can
 *           use the myPath variable.  There is also the
 *           possibility of inadventantly dropping the
 *           synchronized lock in the move method as
 *           this class and any class that use it 
 *           share the same object, and thus the same 
 *           synchronized lock.
 */

abstract public class MoveController {
    Path myPath;

    /**
     *  The move method simply saves the parameter path into
     *  the variable myPath, and does the wait, much like its
     *  procedural cousin.  
     */
    public synchronized void move(Path path) {

        myPath = path;
        try {
            // Note that this wait is wrong, as it could 
            // unintentionally drop a lock on the object
            // that is held by an enclosing synchronized block
            wait();
        } catch (InterruptedException e) {
        }
    }
}
