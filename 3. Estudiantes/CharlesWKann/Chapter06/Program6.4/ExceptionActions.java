/* 
 * TITLE: Program 6.4e
 *
 * @(#) ExceptionActions.java 2002/07/21
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

import java.io.*;

/**
 *  This program shows the types of things you can do when an
 *  exception is caught.  You can translate the exception to
 *  a string, get the message from it, or print the stack trace
 *  to the terminal or to a file.
 */

public class ExceptionActions {
    public static void main(String args[]) {
        int i = 0, j = 7, k;
        try {
            k = j / i;
        } catch(Exception e) {
            try {
                System.out.println("e.toString = " + e.toString());
                System.out.println("e.getMessage = " + e.getMessage());
                e.printStackTrace();
                PrintStream ps = new PrintStream(
                    new FileOutputStream("temp.dbg"));
                e.printStackTrace(ps);
            } catch (IOException e1) {
                System.out.println("file write failed");
            }
        }
    }
}
