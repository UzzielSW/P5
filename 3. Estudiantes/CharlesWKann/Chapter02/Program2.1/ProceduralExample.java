/*
 * TITLE: Program 2.1
 *
 * @(#)ProceduralExample 2002/07/21
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
 *    Purpose:          This program is a simple example of a program
 *                      where all the data flow is procedural, IE. there
 *                      are no threads.  
 *    Procedure:	An object is created, and the "run" method is 
 *			directly called on that object.
 */


public class ProceduralExample {

    public void run() {
        System.out.println("In Run");
    }

    public static void main(String args[]) {
        ProceduralExample pe = new ProceduralExample();
        pe.run();
    }
}
