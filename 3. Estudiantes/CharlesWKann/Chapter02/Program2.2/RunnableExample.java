/*
 * TITLE: Program 2.2
 *
 * @(#)RunnableExample 2002/07/21
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
 *    Purpose:    This program is a simple example of a program
 *                which creates a Thread using the Runnable interface.
 *
 *   
 *    Procedure:	An object is created from a class that 
 *			implements Runnable.  This object is passed to the
 *			thread object when it is created, and when the start
 *			method is called on the thread, object, the run 
 *			method in the Runnable object is called in the
 *			new thread.
 */

public class RunnableExample implements Runnable {
    public void run() {
        System.out.println("In Run");
    }

    public static void main(String args[]) {
        RunnableExample re = new RunnableExample();
        Thread t1 = new Thread(re);
        t1.start();
    }
}
