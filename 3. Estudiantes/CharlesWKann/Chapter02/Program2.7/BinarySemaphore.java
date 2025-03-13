/*
 * @(#)BinarySemaphore 2002/07/21
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

/**
 *    Purpose:    This class implements a binary semaphore used to
 *                lock methods to insure mutual exclusion.
 *
 *    Procedure;	Threads that want to obtain this binary semaphore
 *			lock call getLock, and will obtain the lock when
 *			the locked value is false.
 *
 *			When a thread finishes with the lock it calls
 *			releaseLock which allows other threads to obtain
 * 			this lock.
 */

public class BinarySemaphore {
    private boolean locked = false;
 
    /**
     *   Get the lock. 
     */
    public synchronized void getLock() {
        while (locked) {
            try {
	          wait();
            } catch(InterruptedException e) {
            }
        }
        locked = true;
    }

    /**
     *   Release the lock. 
     */
    public synchronized void releaseLock() {
        locked = false;
        notify();
    }
}
