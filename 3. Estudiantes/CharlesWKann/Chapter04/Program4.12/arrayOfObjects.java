/*
 * TITLE: Program 4.12
 *
 * @(#)ArrayOfObjects.java 2002/07/21
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
 *  This class shows that an array of objects only allocates an array
 *  of references, not the objects themselves.  The objects must be 
 *  allocated in a separately.
 */

class Person {
}

class Car {
}

public class ArrayOfObjects {
    public static void main(String args[]) {
        Object array[] = new Object[10];
        array[0] = new Person();
        array[1] = new Car();
        array[2] = new Object();
        // array[3..9] is unallocated.
    }
}
