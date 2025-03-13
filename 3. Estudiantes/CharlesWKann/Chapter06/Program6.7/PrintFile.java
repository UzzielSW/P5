/* 
 * TITLE: Program 6.7
 *
 * @(#) PrintFile.java 2002/07/21
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

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *  This program is the Java equivalent to the C Program 6.3.
 *  Note that the Java program makes the programmer handle
 *  a problem if the file does not open properly or if there is
 *  a problem while using the file.  This leads to much safer programs.
 */

public class PrintFile {
    public static void main(String args[]) {
        try {
            FileReader fr = new FileReader("tmp.dat");
            BufferedReader br = new BufferedReader(fr);
           
            String s = br.readLine();
            while (s != null) {
                System.out.println(s);
                s = br.readLine();
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
