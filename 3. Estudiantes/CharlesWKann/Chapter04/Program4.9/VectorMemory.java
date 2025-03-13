/*
 * TITLE: Program 4.9
 *
 * @(#)VectorMemory.java 2002/07/21
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
 *  This class shows is used with Figure 4.4 to show how memory
 *  can exist in a program, and why and how it is serialized.
 *  Note that the object named chuck is reference twice
 *  in the vector, but it exists only once.  This must be taken
 *  into account when serializing the record.
 */

import java.util.Vector;

class Person {
    String name;
    public Person(String name) {
    }
}

public class VectorMemory {
    public static void main(String args[]){
        Vector People = new Vector();
        Person chuck = new Person("Chuck));
        People.addElement(chuck);
        People.addElement(new Person("Cindy"));
        People.addElement(chuck);
    }
}
