/*
 * TITLE: Program 2.5
 *
 * @(#)Concurrent 2002/07/21
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
 *    Purpose:    This program is an example of a program
 *                which creates two threads.  Note that
 *			because threads are used, the two run
 *			methods in objects a and b are running
 *			asyncrhonously from each other, and asynchronously
 *			from the main thread.  Therefore the outputs 
 *                      from these three theads can be interleaved, and 6 different
 *			valid outputs are possible.
 *
 *    Procedure:	Two objects are created and used to create
 *			two threads.  The two threads are then started,
 *			and outputs produced.
 */  

public class Concurrent implements Runnable {
    int myNum;

    public Concurrent(int myNum) {
        this.myNum = myNum;
    }

    public static void main(String argv[]) {
        Concurrent a = new Concurrent(1);
        Concurrent b = new Concurrent(2);

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);

        t1.start();
	  t2.start();

        try {
            Thread.sleep((int)(Math.random() * 100));
            System.out.println("in main");
            Thread.sleep((int)(Math.random() * 100));
            System.out.println("in main");
	  } catch(InterruptedException e) {
        }
    }

    public void run() {
        try {
            Thread.sleep((int)(Math.random() * 100));
            System.out.println("in run, myNum = " + myNum);
            Thread.sleep((int)(Math.random() * 100));
            System.out.println("in run, myNum = " + myNum);
        } catch(InterruptedException e) {
	  }
    }
}
