/*
 * TITLE: Program 2.6
 *
 * @(#)ShowRaceCondition 2002/07/21
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
 *    Purpose:          This program creates a race condition by sharing
 *                      the variable "tmp" in the SwapInt Object.  Because
 *                      tmp can be set by both threads before it is
 *                      stored back in the swap, it is possible for both
 *                      swaps to store the same value back in val2.
 *
 *    Procedure:	Start two threads which share a SwapInt object.
 *			Have the two threads use the SwapInt object to 
 *			to swap integers, and show that there is
 *			a race condition in this program.  
 */

public class ShowRaceCondition implements Runnable{
    private int val1, val2;		   // store the values to be swapped.
    static SwapInt so = new SwapInt(); // SwapInt object.  Note that it is
					         // static so it is shared between all
					         // instances of this class.

    /**
     *  Constructor.  It just takes two integers and stores them
     *  so that they can be swapped later.
     */
    public ShowRaceCondition(int i1, int i2){
        val1 = i1; val2 = i2;
    }

    /** 
     *  Run method that simply swaps the integers and prints
     *  the result.
     */
    public void run() {
        so.swap(this);
	System.out.println("Val1 = " + val1 + " Val2 = " + val2);
    }

    /** 
     *  main method that creates and starts the objects and threads
     */
    public static void main(String args[]) {
	
      (new Thread(new ShowRaceCondition(4,7))).start();
      (new Thread(new ShowRaceCondition(2,5))).start();
    }
}


/**
 *   Purpose: Provide an object that swaps integers.
 * 		  An object is needed so that an instance variable
 *		  exists that can be shared.  If a method is used
 *		  variable will be stored on the stack and not shared
 *		  between threads, and no race condition would exist.     
 */
class SwapInt {
    volatile private int tmp;

    public void swap(ShowRaceCondition s) {
        try {
            Thread.sleep((int) (Math.random() * 100));
            tmp = s.val1;
            s.val1 = s.val2;
            Thread.sleep((int) (Math.random() * 100));
            s.val2 = tmp;
        } catch (InterruptedException e) {
        }
    }
