/*
 * TITLE: Program 4.5
 *
 * @(#)CatchCast.java 2002/07/21
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
 *  This class shows how the run time data type tag can be used to
 *  insure errors in casting are properly handled.  Here when the
 *  Person object is cast to a Car Object, (which is obviously 
 *  invalid, the cast results in an exception being raised, and
 *  an appropriate error message being produced.
 */

class Person {
}

class Car{
}

public class CatchCast {
    public static void main(String args[]) {
        try {
            Object o1 = new Person();
            Car c1 = (Car)o1;
        } catch (ClassCastException cce) {
            System.out.println("The program produced a class cast exception");
            System.out.println("Please call your software representative");
        }
    }
}
