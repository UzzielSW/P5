/*
 * TITLE: Program 3.1b
 *
 * @(#)Consumer 2002/07/21
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
 *  This class consumes integers which have been added to the shared
 *  BoundedBuffer object.
 */
public class Consumer implements Runnable {
    private BoundedBuffer bb;  // BoundedBuffer used to coordinate
                               // with the Producer

    /**
     *  Constructor that saves the shared BoundedBuffer object.
     */
    public Consumer(BoundedBuffer bb) {
        this.bb = bb;
    }

    /**
     *  Producer thread, which creates values and passes
     *  them to the BoundedBuffer.
     */
    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.println("Consumer got value = " +
                bb.takeFromBuffer());
        }
    }
}
