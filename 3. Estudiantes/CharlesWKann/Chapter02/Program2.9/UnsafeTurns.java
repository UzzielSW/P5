/*
 * TITLE: Program 2.9
 *
 * @(#)UnsafeTurns 2002/07/21
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

import java.util.*;

/**
 *    Purpose:    This program runs two threads that do not 
 *			take turns.
 *
 *    Procedure:	Create a TurnPrinter object and give that
 *			object to two threads that are created.  
 *			Start the two threads.
 */


public class UnsafeTurns implements Runnable {
    private static Random rand = new Random();
    private TurnPrinter tp;
    private int myNum;

    public UnsafeTurns(TurnPrinter tp, int myNum) {
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
        (new Thread(new UnsafeTurns(tp, 1))).start();
        (new Thread(new UnsafeTurns(tp, 2))).start();
    }
}


/**
 *    Purpose: 	This TurnPrinter is intended to coordinate
 *			threads that want to take turns printing.
 *			it does not work.
 */
class TurnPrinter {
    public synchronized void printTurn(int turn) {
        System.out.println("turn is " + turn);
    }
}
