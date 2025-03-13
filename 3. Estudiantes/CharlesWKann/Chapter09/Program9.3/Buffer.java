/*
 * TITLE: Program 9.3a
 *
 * @(#)Buffer.java 2002/07/21
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
 *    Purpose: This class simulates a buffer that allows multiple readers to
 *             use it concurrently, but only a single thread can use it if that
 *             thread will write to it.  To achieve this, the buffer must have
 *             at least one unsynchronized method.  To make sure that this 
 *             unsynchronized method cannot be called unsafely, the actual buffer
 *             that is being used is encapsulated (hidden) inside of a public adapter
 *             which limits the access to the buffer so that all operations are safe.
 *
 *             This buffer is not a "real" buffer in that it does not store or retrieve 
 *             information.  Instead it simulates operations that would be performed
 *             on a buffer with a small wait time to make it more realistic.
 */

public class Buffer {
    private HiddenBuffer hb = new HiddenBuffer();  // The actual buffer used.  Access to
                                                   // this buffer is only through the read
                                                   // and write methods.

    /**
     *  read an object from the buffer.  Note that to make this work the intention to
     *  read the buffer must first be declared by calling beginRead.  The unsynchronized 
     *  method doRead can then be called.  Finally the thread must say that it is 
     *  finished by calling endRead.
     *
     *  Because this is all encapsulated in this method, the user of this buffer only
     *  needs to call this method as "Object o = buffer.read()", and the details will
     *  be handled.
     */
    public Object read() {
        System.out.println("Reader waiting for buffer");
        hb.beginRead();
        System.out.println("Reader got buffer");
        Object returnObject = hb.doRead();
        hb.endRead();
        System.out.println("Reader finished");
        return returnObject;
    }

    /**
     *  write an object ot the buffer.  Note that first the intention to write to the
     *  buffer must be declared by calling requestWrite.  When the buffer is safe,
     *  the doWrite method is called, allow the write to finish.
     */
    public void write(Object o) {
        System.out.println("Writer requesting buffer");
        hb.requestWrite();
        hb.doWrite(new Object());
        System.out.println("Writer done with buffer");
    }

    /**
     *  This is the actual buffer object.
     */
    private class HiddenBuffer {
        // Buffer state variables.
        private static final int READABLE = 0;
        private static final int WAITING_TO_WRITE = 1;
        private static final int WRITING = 2;
        private int state = READABLE;

        private int numberOfReaders = 0;
        private Object notifyObject = new Object();  // Note - Only a single notification
                                                     // object is used so only a single writer
                                                     // will can be notified.  Also note that
                                                     // we cannot use the object to be written
                                                     // as the notification object as 
                                                     // the user could have that one locked
                                                     // already.

        /**
         *  This method declares a thread's intent to do a read.  It protects the
         *  doRead method, and returns when it is safe to call the doRead method.
         */
        public synchronized void beginRead() {
            while( ! (State == READABLE) {
                try {
                    wait();
                } catch(InterruptedException e) {
                }
            }

            numberOfReaders++;

            //No post condition as state will not change.
        }

        /**
         *  This method reads the data from the buffer and returns the object.  Note this
         *  is only simulated here by a .5 second delay.   Also note that this method
         *  is unsynchronized, allowing multiple simultaneous readers.
         */
        public Object doRead() {
            try {
                Thread.sleep(500);  // .5 second delay
            } catch(InterruptedException e) {
            }

            return new Object();
        }

        /**
         *  This method declares the thread to have completed reading the buffer.  If any
         *  thread is waiting to write, when the numberOfReaders becomes 0, allow the writer
         *  thread to continue.
         */
        public synchronized void endRead() {
            while ( ! ((state == READABLE) ||
                      (state == WAITNG_TO_WRITE))) {
                try {
                    wait();
                } catch(InterruptedException e) {
                }
            }

            numberOfReaders--;

            if ((numberOfReaders == 0) && (state == WAITING_TO_WRITE)) {
                state = WRITING;
                synchronized(notifyObject) {
                    notifyObject.notify();
                }
            }
        }

        /**
         *  This method allows a writer thread to declare its intent to read from the buffer.
         *  This method will return when it is safe to call the doWrite method.
         */
        public void requestWrite() {
            Object temp = new Object();
            synchronized (temp) {
                synchronized(this) {
                    notifyObject = temp;
                    // can only requestWrite from state READABLE.  This
                    // means only one writer can be waiting at a time, others
                    // must wait here.  
                    // Note that the wait drops the lock on the HiddenBuffer
                    // object, but holds it on the temp object.  This is not
                    // a problem as the temp object does not have scope outside 
                    // of this method yet.
                    while (! (state == READABLE)) {
                        try {
                            wait();
                        } catch(InterruptedException e) {
                        }
                    }

                    //Post Conditions
                    if (numberOfReaders == 0) {
                        state = WRITING;
                        // notifyAll(); //Not needed.
                        notifyObject = null;
                    }
                    else {
                        state = WAITING_TO_WRITE;
                        // notifyAll(); //Not needed.
                    }
                }

                // Note that we have to do the waiting to write
                // here while we still hold the notifyObject lock.
                if (notifyObject != null){
                    try {
                        notifyObject.wait();
                    } catch(InterruptedException e) {
                    }
                }
            }
        }

        /**
         *  This method writes the data from the buffer and returns the object.  Note this
         *  is only simulated here by a .5 second delay.
         */
        public synchronized void doWrite(Object o) {
            while( ! (state == WRITING)) {
                try {
                    wait();
                } catch(InterruptedException e) {
                }
            }

            // Here the write would be done.
            try {
                Thread.sleep(500);
            } catch(InterruptedException e) {
            }

            // Post Condition

            state = READABLE;
            notifyAll();
        }

    }
}
