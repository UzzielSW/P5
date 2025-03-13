/*
 * TITLE: Program 4.10
 *
 * @(#)Person.java 2002/07/21
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
 *  This class writes an XML stream of the data defined by the Vector in Program 4.9.
 *  Note that to use the XMLEncoder or XMLDecoder the classes must be Beans, which
 *  means that they have to have properties with set and get methods, as done with the
 *  name property (variable) in this example.
 */
import java.util.Vector;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.beans.XMLEncoder;
import java.io.Serializable;

public class Person implements Serializable {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String args[]){
        try {
            Vector People = new Vector();
            Person chuck = new Person("Chuck");
            People.addElement(chuck);
            People.addElement(new Person("Sam"));
            People.addElement(chuck);
            XMLEncoder e = new XMLEncoder(
                               new BufferedOutputStream(
                                   new FileOutputStream("out.xml")));
           e.writeObject(People);
           e.close();
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

}
