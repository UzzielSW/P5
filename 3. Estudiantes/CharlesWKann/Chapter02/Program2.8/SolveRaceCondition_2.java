/*
 * TITLE: Program 2.8
 *
 * @(#)SolveRaceCondition_2 2002/07/21
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

public class SolveRaceCondition_2 implements Runnable{
    private int val1, val2;
    static SwapInt so = new SwapInt();

    public SolveRaceCondition_2(int i1, int i2){
	  val1 = i1; val2 = i2;
    }

    public void run() {
        so.swap(this);
	  System.out.println("Val1 = " + val1 + " Val2 = " + val2);
    }

    public static void main(String args[]) {
	
        (new Thread(new SolveRaceCondition_2(4,7))).start();
        (new Thread(new SolveRaceCondition_2(2,5))).start();
    }
}

/**
 *   Purpose:  This class shows the use of the synchronized 
 *		   clause to lock the swap method.
 */

class SwapInt {
    private int tmp;

    synchronized public void swap(SolveRaceCondition_2 s) {
        Thread.sleep((int) (Math.random() * 100));
        try {
            Thread.sleep((int) (Math.random() * 100));
            tmp = s.val1;
            s.val1 = s.val2;
            Thread.sleep((int) (Math.random() * 100));
            s.val2 = tmp;
        } catch (InterruptedException e) {
        }
    }
}

