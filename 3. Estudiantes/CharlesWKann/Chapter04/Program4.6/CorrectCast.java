/*
 * TITLE: Program 4.6
 *
 * @(#)CorrectCast.java 2002/07/21
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
 *  This class shows how invalid casting errors can be avoided.  
 *  Here the variable object can randomly be assigned to either a 
 *  Car object or a Person object.  In order to cast it correctly
 *  its run time data type tag is examined to see which it really
 *  is, and it is cast appropriately.
 */

class Person {
}

class Car {
}

public class CorrectCast {
    public static void main(String args[]) {
        Object object;

        // Randomly choose to create a Car or 
        // Person Object.
        int flag = (int)(2.0 * Math.random());
        if (flag == 0)
            object = new Car();
        else
            object = new Person();

        // Cast to the correct Object
        if (object instanceof Person) {
            Person person = (Person)object;
        }
        else if (object instanceof Car) {
            Car car = (Car)object;
        }
    }
}
