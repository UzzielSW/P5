/* 
 * TITLE: Program 6.4b
 *
 * @(#) TryCatch2.java 2002/07/21
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
 *  This program shows a simple try catch block in a program.  In
 *  this program the exception is raised, so the catch block
 *  is executed.  Once the catch is executed, the exception is
 *  disguarded and the program continues at the end of the block.
 */

public class TryCatch2 {
    public static void main(String args[]) {
        int i = 0, j = 7, k;

        try {
            // this division results in a zero divide
            // and immediately branches to the catch block
            k = j / i;

            System.out.println("Statement is not executed");
        } catch(ArithmeticException e) {
            System.out.println("Zero divide occured");
        }

        // The exception was handled, so we continue
        System.out.println("This is after the exception is handled");
    }
}
