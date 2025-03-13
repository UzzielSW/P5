/*
 * TITLE: Program 2.11
 *
 * @(#)SafeTurns1 2002/07/21
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

import java.util.Random;

/**
 *    Purpose:    This program fixes the problem in
 *			Program 2.10, but by recognizing that
 *			the component is flawed, and having the
 *			program make an allowance for the 
 *			incorrect behavior in the component.
 *
 *    Procedure:	Create a TurnPrinter object and give that
 *			object to two threads that are created.  
 *			Start the two threads.  Have the turn
 *			printer object wait after printing the
 *			turn, and have the second thread notify
 *			after it has printed its turn.  In this
 *			way the two threads take turns.
 *			
 *			The program always does a notify after
 *			it has finished running in order to
 *			insure that the last thread is notified 
 *			so the program runs correctly.
 */

public class SafeTurns1 implements Runnable {
    static private Random rand = new Random();
    private TurnPrinter tp;
    private int myNum;

    public SafeTurns1(TurnPrinter tp, int myNum) {
        this.tp = tp;
        this.myNum = myNum;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            tp.printTurn(myNum);
            try {
                Thread.sleep(rand.nextInt(100));
            } catch (InterruptedException e) {
            }

            synchronized(tp) {
                tp.notify();
            }
        }
    }

    public static void main(String args[]) {
        TurnPrinter tp = new TurnPrinter();
        (new Thread(new SafeTurns1(tp, 0))).start();
        (new Thread(new SafeTurns1(tp, 1))).start();
    }
}

/**
 *    Purpose: 	This TurnPrinter is intended to coordinate
 *			thread and make them take turns.  It works
 *			However the first notify occurs before the
 *			first wait, and is lost.  Since the number
 *			of notifies matches the number of waits, 
 *			one thread ends up stuck waiting for a 
 *			notify that never occurs.  This is accounted
 *			for in the program using the component.
 */
class TurnPrinter {
    public synchronized void printTurn(int turn) {
        try {
            notify();
            System.out.println("turn is " + turn);
            wait();
        } catch (InterruptedException e) {
        }
    }
}
