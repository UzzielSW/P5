/* 
 * TITLE: Program 6.6
 *
 * @(#) FinallyExample.java 2002/07/21
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
 *  This program shows how the finally block is used in a program.
 *  Note that a finally block is always executed, regardless of
 *  whether an exception is raised or not, caught or not, or even
 *  when there is a return statement in a program.
 */


public class FinallyExample {

    public void f1() {
        try {
            f2();
        } catch (ArithmeticException e) {
            System.out.println("Error is handled here");
            return;  // Note that even though there is a return
                     // statement here, the finally block is executed.
        } finally {
            System.out.println("Error is handled, and finally block executed");
        }
    }

    public void f2() {
        int i = 0, j = 7, k;
        try {
            // this division results in a zero divide
            // and immediately branches to the catch block
            k = j / i;
            System.out.println("Statement is not executed");
        } catch(ClassCastException e) {
            System.out.println("This does not catch the zero divide");
        } finally {
            System.out.println("Error is not handled, but finally executed");
        }
    }

    public static void main(String args[]) {
        FinallyExample ep = new FinallyExample();
        try {
            ep.f1();
        } catch (ArithmeticException e) {
            System.out.println("Exception was already handled");
            System.out.println("So we skip this statement");
        } finally {
            System.out.println("No error, but finally still executed.");
        }
    }
}
