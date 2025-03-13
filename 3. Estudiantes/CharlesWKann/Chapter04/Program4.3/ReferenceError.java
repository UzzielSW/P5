/*
 * TITLE: Program 4.3
 *
 * @(#)ReferenceError.java 2002/07/21
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
 *  for objects in Java can be different.  In this case a compiler
 *  error is generated because the compiler does not know that the 
 *  object being reference is indeed a Person.
 */

class Person {
    String name;
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class ReferenceError {
    public static void main(String args[]) {
        Object o1 = new Person("Chuck");
        o1.getName();
    }
}
