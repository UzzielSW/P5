/*
 * TITLE: Program 2.3
 *
 * @(#)ThreadExample 2002/07/21
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
 *                which creates a Thread extending the Thread class. 
 *
 *    Procedure:	Note that because Thread implements Runnable,
 *			the ThreadExample object is a Runnable object.
 *			Because the constructor for the thread was called
 *			without an argument, the run method will be 
 *			called using the "this" argument, or the
 *			ThreadExample object.
 *  
 */

public class ThreadExample extends Thread {
    public void run() {
        System.out.println("In Run");
    }

    public static void main(String args[]) {
        ThreadExample t1 = new ThreadExample();
        t1.start();
    }
}
