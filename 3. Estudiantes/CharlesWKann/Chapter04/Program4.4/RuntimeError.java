/*
 * TITLE: Program 4.4
 *
 * @(#)RunTimeError.java 2002/07/21
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
 *  This class shows that the compile time and run time data types
 *  for objects in Java can be different.  In this case a run time
 *  error is generated.  The compiler could not insure that the
 *  cast of object o2 to a Person was valid, so it forced the 
 *  programmer to take responsibility for it by doing an explicit
 *  cast.  In this case, the programmer was wrong, and the cast
 *  is checked at run time and found to be invalid.
 */

class Person {
}

class Car {
}

public class RuntimeError {
    public static void main(String args[]) {
        Object o1 = new Person();
        Object o2 = new Car();
        Person p1 = (Person) o1;
        Person p2 = (Person) o2;
    }
}
