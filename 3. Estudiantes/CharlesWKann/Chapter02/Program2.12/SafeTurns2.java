/*
 * TITLE: Program 2.12
 *
 * @(#)SafeTurns2 2002/07/21
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
 *    Purpose:    This program runs two threads that take 
 *			turns properly.
 *
 *    Procedure:	Create a TurnPrinter object and give that
 *			object to two threads that are created.  
 *			Start the two threads.  Have the turn
 *			printer object wait keep track of whose 
 *			turn it is, and let the proper thread 
 *			enter when it is their turn.  This is
 *			a correct component.
 */

public class SafeTurns2 implements Runnable {
    static Random rand = new Random();
    TurnPrinter tp;
    int myNum;

    public SafeTurns2(TurnPrinter tp, int myNum) {
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
        }
    }

    public static void main(String args[]) {
        TurnPrinter tp = new TurnPrinter();
        (new Thread(new SafeTurns2(tp, 0))).start();
        (new Thread(new SafeTurns2(tp, 1))).start();
    }
}

/**
 *    Purpose: 	This TurnPrinter is coordinates threads
 *			so they take turns.  It works by keeping
 *			track of whose turn it is to run the 
 *			method, and allowing that thread only to
 *			run.
 */
class TurnPrinter {
    int currentTurn = 0;
    public synchronized void printTurn(int turn) {
        try {
            if (currentTurn != turn)
                wait();
            System.out.println("turn is " + turn);
            currentTurn = (currentTurn + 1) % 2;
            notify();
        } catch (InterruptedException e) {
        }
    }
}
