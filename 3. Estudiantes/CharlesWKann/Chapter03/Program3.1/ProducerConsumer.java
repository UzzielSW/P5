/*
 * TITLE: Program 3.1d
 *
 * @(#)ProducerConsumer 2002/07/21
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
 *  This class builds all the parts of the Producer/consumer
 *  simulation.  It creates the BoundedBuffer object, and then
 *  creates a Producer thread and Consumer thread, giving each 
 *  thread a copy of the shared buffer so they can communicate.
 */


public class ProducerConsumer {
    public static void main(String args[]) {
        BoundedBuffer bb = new BoundedBuffer(3);
        (new Thread(new Producer(bb))).start();
        (new Thread(new Consumer(bb))).start();
    }
}
