/*
 * TITLE: Program 2.13
 *
 * @(#)MakeDeadlock 2002/07/21
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
 *    Purpose:    This program forces a circular deadlock.
 *			It does this by having threads obtain
 *			objects in reverse order.  If one thread
 *			can get both objects before the other
 *			gets one, then the deadlock does not
 *			occurr, but if each get one, the 
 *			deadlock is a problem.
 *
 *    Procedure:	1 - Create two objects to lock on.
 *			2 - Create and start two threads.  The
 *			    first thread locks object a, then
 *			    object b, and the second locks
 *			    object b then object a.
 *			
 */

public class MakeDeadlock{
    public static void main(String args[]){
        Object a = new Object(), b = new Object();
        Thread thread_1 = new Thread(new LockAB(a,b));
        thread_1.start();
        Thread thread_2 = new Thread(new LockBA(a,b));
        thread_2.start();
    }
}

class LockAB implements Runnable {
    private Object a, b;
    public LockAB(Object a, Object b) {
        this.a = a; this.b = b;
    }

    public void run() {
        try {
            Thread.sleep((int)(Math.random() * 100));
            synchronized(a) {
                Thread.sleep((int)(Math.random() * 100));
                synchronized(b) {
                    System.out.println("LockAB worked");
                }
            }
        } catch (InterruptedException e) {
        }
    }
}

class LockBA implements Runnable {
    private Object a, b;
    public LockBA(Object a, Object b) {
        this.a = a; this.b = b;
    }

    public void run() {
        try {
            Thread.sleep((int)(Math.random() * 100));
            synchronized(b) {
                Thread.sleep((int)(Math.random() * 100));
                synchronized(a) {
                    System.out.println("LockBA worked");
                }
            }
        } catch (InterruptedException e) {
        }
    }
}



