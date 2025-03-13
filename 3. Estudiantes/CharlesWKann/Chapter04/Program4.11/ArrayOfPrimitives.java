/*
 * TITLE: Program 4.11
 *
 * @(#)ArrayOfPrimitives.java 2002/07/21
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
 *  This class shows the difference between an array of objects and
 *  an array of primitives.  In this case, the array of primitives
 *  actually creates all of the primitives when the array is created.
 *
 *  It also shows that an array can be treated like an object in that
 *  it can be written to an ObjectStream.
 */

import java.io.*;

public class ArrayOfPrimitives {
    public static void main(String args[]) {
        try {
            int array[] = new int[10];
            ObjectOutputStream oos = new ObjectOutputStream (
                                     new FileOutputStream("temp.dat"));
            oos.writeObject(array);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
