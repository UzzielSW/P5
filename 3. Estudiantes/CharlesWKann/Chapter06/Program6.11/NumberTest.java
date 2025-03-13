/* 
 * TITLE: Program 6.11b
 *
 * @(#) NumberTest.java 2002/07/21
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
 *  This program uses the NumberOutOfBoundsException defined
 *  in Program 6.11a.  
 */

public class NumberTest {

    public int getNumber() throws NumberOutOfBoundsException {
        int number = 0;
        try {
            StreamTokenizer st = new StreamTokenizer(
                                new BufferedReader(
                                new InputStreamReader(System.in)));
            st.nextToken();
            number = (int)st.nval;
            if (! (number > 0 && number < 100))
                throw new NumberOutOfBoundsException(
                    "Invalid Number", number);
       } catch (IOException e) {
           e.printStackTrace();
       }
       return number;
    }

    public static void main(String args[]) {
        NumberTest nt = new NumberTest();
        int number = 0;
        while(true) {
            try {
                System.out.println("Enter a number from 1 to 100");
                number = nt.getNumber();
                break;
            } catch(NumberOutOfBoundsException e) {
                System.out.println("Invalid Number " + e.getNumber() +
                    " try again\n");
            }
        }
        System.out.println("number = " + number);
    }
}
