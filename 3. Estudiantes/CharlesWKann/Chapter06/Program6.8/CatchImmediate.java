/* 
 * TITLE: Program 6.8
 *
 * @(#) CatchImmediate.java 2002/07/21
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *  There are two ways to handle a checked excpetion.  The first
 *  is to catch it.  This program shows catching a checked exception,
 *  in this case a FileNotFoundException thrown when using the  
 *  constructor or the FileInputStream.
 */


public class CatchImmediate {
    public FileInputStream openFile(String fileName) {
        FileInputStream fis = null;
        try {
             fis = (new FileInputStream(fileName));
        } catch(FileNotFoundException fnfe) {
             fnfe.printStackTrace();
        }
        return fis;
    }
}
