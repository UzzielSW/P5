/*
 * TITLE: Program 2.7b
 *
 * @(#)SolveRaceCondition 2002/07/21
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
 *    Purpose:    This program implements a safe swap of two variables.
 *    		Note: This program is identical to the ShowRaceCondition.
 *			The difference is in the SwapInt class.
 *			 
 */

public class SolveRaceCondition implements Runnable{
    int val1, val2;
    static SwapInt SO = new SwapInt();

    public SolveRaceCondition(int i1, int i2){
        val1 = i1; val2 = i2;
    }

    public void run() {
        SO.swap(this);
        System.out.println("Val1 = " + val1 + " Val2 = " + val2);
    }

    public static void main(String args[]) {
      (new Thread(new SolveRaceCondition(4,7))).start();
      (new Thread(new SolveRaceCondition(2,5))).start();
    }
}

/**
 *    Purpose: 	This SwapInt object shows how a lock can be
 *			used to prevent two threads from sharing a
 *			critical section, thus fixing a race condition.
 *
 *    Procedure:	1 - Get the lock; 2 - Execute the Critical 
 *			section; 3 - Release the lock.
 */

class SwapInt {
    private volatile int tmp;
    private BinarySemaphore mutex = new BinarySemaphore();

    public void swap(SolveRaceCondition s) {
        mutex.getLock();
        try {
            Thread.sleep((int) (Math.random() * 100));
            tmp = s.val1;
            s.val1 = s.val2;
            Thread.sleep((int) (Math.random() * 100));
            s.val2 = tmp;
        } catch (InterruptedException e) {
        }
        mutex.releaseLock();
    }
