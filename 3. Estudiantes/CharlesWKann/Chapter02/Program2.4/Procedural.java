/*
 * TITLE: Program 2.4
 *
 * @(#)Procedural 2002/07/21
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
 *
 *    Purpose:    This program is a simple example of a program
 *                where all the data flow is procedural, IE. there
 *                are no threads.  Therefore the run method for object
 *			a will be called and complete before the run method
 *			for object b.  This program can produce only one
 *			output.
 *  
 *    Procedure:	This program creates two objecs and then calls
 *			the run methods on each object.
 */

public class Procedural {
    private int myNum;

    public Procedural(int myNum) {
        this.myNum = myNum;
    }

    public static void main(String argv[]) {
        Procedural a = new Procedural(1);
        Procedural b = new Procedural(2);
        a.run();
        b.run();
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

