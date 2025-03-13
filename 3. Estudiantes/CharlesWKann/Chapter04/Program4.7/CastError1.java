/*
 * TITLE: Program 4.7
 *
 * @(#)CastError1.java 2002/07/21
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
 *  This class shows how an instance of a class cast error that 
 *  cannot be caught by the compiler.  The Person object is cast
 *  to an Object, which is then cast to a Car.  This is always an 
 *  error, but cannot be detected by the compiler, and will result 
 *  in a run time error.
 */

class Person {
    String Name;
}

class Car {
    int EngineSize;
}

public class CastError1 {
    public static void main(String args[]) {
        Person person = new Person();
        Object object = person;
        Car car = (Car)object;
    }
}
