/* 
 * TITLE: Program 6.9
 *
 * @(#) Propagate.java 2002/07/21
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
import java.io.IOException;

/**
 *  There are two ways to handle a checked excpetion.  The second
 *  is to explicitly propogate it.  This program shows propagating
 *  the FileNotFoundException by having the method through the exception
 *  rather than handle it.  Note that the method throws an IOException,
 *  not a FileNotFoundException.  But because the IOException is the
 *  parent of the FileNotFoundException, it can be used as a proxy for
 *  the exception.  Note that only the FileNotFoundException can ever
 *  be thrown, but by using the IOException the calling method must now
 *  handle the IOException.
 */

public class Propagate {
    public FileInputStream openFile(String fileName) throws IOException {
        return new FileInputStream(fileName);
    }
}
