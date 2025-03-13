/* 
 * TITLE: Program 6.1
 *
 * @(#) Person.java 2002/07/21
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
 *  This impelments a Person class.  This Person class has been
 *  changed from the one implemented in Chapter 5 by including error
 *  handling in the gt method.  If a Sortable object is passed to the
 *  gt method, and that Sortable object is not a Person object, it is
 *  an error.   The method prints an error message and returns "false".
 *  Note that this implies that an invalid object is less than any person
 *  object.  This is not likely the behavior that was expected or wanted.
 */  

public class Person implements PrintableSortable
{
    private String name;
    public Person1(String name){
        this.name = new String(name);
    }
	    
    public void print(){
        System.out.println("My Name is " + name);
    }
	
    public boolean gt(Sortable p) {
        // We check here to make sure that the object
        // passed in is indeed of the correct type.
        if (! (p instanceof Person)) {
            System.out.println("Invalid object type, must be a Person");
            return false;
        }
        else if (name.compareTo(((Person1)p).name) > 0)
            return true;
	  else
	      return false;
    }
	
    public boolean eq(Sortable P) {
        return true;
    }
}
