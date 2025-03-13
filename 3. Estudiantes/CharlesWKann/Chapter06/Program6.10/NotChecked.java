/* 
 * TITLE: Program 6.10
 *
 * @(#) NotChecked.java 2002/07/21
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
 *  This program is meant to dispell a common misconception about 
 *  checked and unchecked exceptions.  Note that the throwUnchecked
 *  method now explicitly throws the ArithmeticException.  However
 *  the exception does not have to be caught or thrown because it
 *  is unchecked.  It is not the presence of the throws clause that
 *  makes the exception checked, it is the type of the exception.
 */


public class NotChecked {
    public static void throwUnchecked() throws ArithmeticException {
        int i = 0, j = 7, k;
        k = j / i;
    }

    public static void main(String args[]) {
        // Note no try block is needed to call method
        throwUnchecked();
    }

}
