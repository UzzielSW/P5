/*
 * TITLE: Program 9.1
 *
 * @(#)FIFOBS.java 2002/07/21
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

import java.util.Vector;
import java.util.Random;

/**
 *    Purpose: This program implements a First-In-First-Out (or Fair) 
 *             Counting Semaphor.  To implement this semaphore a notification
 *             object is used to notify a specific waiting thread to wake up when
 *             the lock is released. 
 */

public class FIFOBS  {
    private boolean locked;  // State of the semaphore
    private Vector waiting;  // Vector of notification objects.  Objects are released
                             // in the order they are entered into the vector.

    /**
     *   public constructor.  Set the monitor state and create the waiting object vector.
     */
    public FIFOBS () {
        locked = false;
        waiting = new Vector();
    }

    /**
     *  get the lock on this semaphore if it is available.  If the lock is not available,
     *  then put a notification object on the wait list to wait until the semaphore is 
     *  free.
     */ 
    public void getLock(){
        Object waitObject = new Object();
        synchronized(waitObject) {
            synchronized(this) {
                if (locked) {
                    waiting.addElement(waitObject);
                }
                else{
                    waitObject = null;  // No need to wait, get rid of object
                }
                locked = true;  // Note that this needs to be set while holding the
                                // semaphore object (this) lock.
            }

            if (waitObject != null) {
                try {
                     waitObject.wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }      


    /**
     *  release the lock on the semaphore.  If any thread is waiting, notify the thread
     *  that has been witing longest,  do not release the lock.  This allows the lock to 
     *  transfer to the notified thread.  Since the lock is never true, it cannot be 
     *  acquired by any other thread.  If no waiting threads, set the sempaphore to unlocked.
     */
    public synchronized void releaseLock() {
        if (waiting.size() > 0) {
            Object wakeObject = waiting.firstElement();
            waiting.removeElementAt(0);
            synchronized(wakeObject) {
                wakeObject.notify();
            }
        }
        else {
            locked = false;
        }
    }

    /**
     *  Main test program.
     */
    public static void main(String args[]) {
        FIFOBS fifobs = new FIFOBS();
        Thread a[] = new Thread[10];
        for (int i = 0; i < 10; ++i) {
            (new Thread(new testP(fifobs, i))).start();
        }
    }
}


/**
 *  This class simply creates the thread that allows us to test the semaphore.
 */
class testP implements Runnable {
    FIFOBS fifobs;
    int id;
    Random random;
    public testP(FIFOBS fifobs, int id) {
        this.fifobs = fifobs;
        this.id = id;
        random = new Random(id);
    }

    public void run() {
        try {
            Thread.sleep(random.nextInt(500));
            System.out.println("Process " + id + " Waiting");
            fifobs.getLock();
            System.out.println("Process " + id + " In Critical Section");
            Thread.sleep(500);
            System.out.println("Process " + id + " Free");
            fifobs.releaseLock();
        } catch(InterruptedException e) {
        }
    }
}

