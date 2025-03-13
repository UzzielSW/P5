/* 
 * TITLE: Program 6.5
 *
 * @(#) ErrorPropogation.java 2002/07/21
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
 *  This program shows propogation of an exception.  If an
 *  exception is raised, it begins to look through try blocks
 *  in an LIFO order until it finds a block that will handle 
 *  this exception.  If none is found, the exception is
 *  propogated to the JVM.
 */


public class ErrorPropogation {

    public void f1() {
        try {
            f2();
        } catch (ArithmeticException e) {
            System.out.println("Error is handled here");
        }
        System.out.println("Error has been handled in f1");
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
        }
        System.out.println("Error was not handled, so we skip this");
    }

    public static void main(String args[]) {
        ErrorPropogation ep = new ErrorPropogation();
        try {
            ep.f1();
        } catch (ArithmeticException e) {
            System.out.println("Exception was already handled");
            System.out.println("So we skip this statement");
        }

        // The exception was handled, so we continue
        System.out.println("This is after the exception is handled");
    }
}
