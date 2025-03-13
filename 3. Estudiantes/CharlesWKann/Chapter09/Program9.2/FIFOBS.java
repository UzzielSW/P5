/*
 * TITLE: Program 9.
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
 *    Purpose: The program implements a FIFOBS as in program 9.1, but implements the
 *             semaphore so that it still has the monitor structure from chapter 3 of
 *             a pre and post condition to handle the monitor function.  Note that to
 *             accomplish this waiting correctly the locked variable and the number of 
 *             waiting threads must be checked.  The semaphore is not free unless there
 *             are no threads waiting and the semaphore is unlocked.  This allows the 
 *             lock on the "this" object to be dropped and reacquired safely.  The 
 *             boolean locked is set in the same synchronized block where the vector
 *             is decremented.
 */

public class FIFOBS  {
    private boolean locked;
    private Vector waiting;

    /**
     *  public constructor.  Initialize the locked variable and create waiting vector.
     */
    public FIFOBS () {
        locked = false;
        waiting = new Vector();
    }

    /**
     *  get the lock on this semaphore if it is free.  Note that here the method still has
     *  pre and post conditions, but extra code for locking has to be considered to make this
     *  work.
     */
    public void getLock(){

        // Precondition for the wait object.
        Object waitObject = new Object();
        synchronized(waitObject) {
            synchronized(this) {
                waiting.addElement(waitObject);
                if ( ! (locked || waiting.size() > 1))
                    waitObject = null;
            }

            if (waitObject != null ) {
                try {
                    waitObject.wait();
                } catch (InterruptedException e) {
                }
            }
        }

        // Code section.  Note that there is no race condition here as
        // only a thread that comes through when no one is waiting or
        // the lock is free.
        synchronized (this) {
           locked = true;
           waiting.removeElementAt(0);
         
        // Post condition.  Note that the notifyAll here on the monitor
        // is useless as no threads are ever waiting on the monitor
        // itself.  Also note that the synchronized block from the code section
        // should include the post condition processing.
        }

    }

    /**
     *  release any locks held.  If there are any threads waiting, notify the one waiting
     *  the longest that this lock is now free.  Note that the lock variable can be 
     *  changed in this method now.
     */
    public synchronized void releaseLock() {

        // Pre-condition is locked is "true", but this thread holds the
        // lock, so it must be true.

        // Code section
        locked = false;

        // Post condition.  Note you can only notify on notify object 
        // if someone is waiting.
        if (waiting.size() > 0) {
            Object wakeObject = waiting.firstElement();
            synchronized(wakeObject) {
                wakeObject.notify();
            }
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

