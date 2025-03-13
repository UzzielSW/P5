/*
 * TITLE: Program 4.14
 *
 * @(#)ShowVector.java 2002/07/21
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
 *  This class illustrates some of the added functionality that comes
 *  from using a collection class, such as a vector, over using a 
 *  simple Object array.
 */

import java.util.Vector;

class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public boolean equals(Object object) {
        return this.name.equals(((Person)object).name);
    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class ShowVector {
    private static Vector people = new Vector();

    public static void main(String args[]) {
        people.add(new Person("Chuck"));
        people.add(new Person("Patty"));
        people.add(new Person("Linda"));

        // Note this line puts the new record in at component
        // 2 in the Vector, and moves everything else down one
        // place in the vector.

        people.add(1, new Person("Cindy"));

        // Print the Vector to show the add worked.

        for (int i = 0; i < people.size(); i++) {
            System.out.println("Person = "  + people.elementAt(i));
        }

        // Now find the record "Chuck"

        int elementNo = people.indexOf(new Person("Chuck"));
        System.out.println("Chuck at " + elementNo);
    }
}
