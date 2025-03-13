/*
 * TITLE: Program 5.4c
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
 *  This application implements the SortedPrintTable for a Person object.
 *  Note to use a Person object in the table, the Person object extended
 *  PrintableSortable, and then defines the print, gt, and eq methods.
 */  


import java.io.*;
public class Person implements PrintableSortable {
    private String name;

    /**
     *   Public constructor.
     */ 
    public Person(String name){
        this.name = new String(name);
    }
	
    /**
     *  Method to satisfy the Printable interface.  Just
     *  prints the name to system.out.
     */    
    public void print(){
        System.out.println("My Name is " + name);
    }
 
    /**
     *  greater than (gt) method, which simply compares two name
     *  strings and returns true it this name string is lexically
     *  greater than the one for the person to compare it to, else
     *  false
     */	
    public boolean gt(Sortable P) {

        // Note that we have to type cast here.
        if (name.compareTo(((Person)P).name) > 0)
	      return true;
	  else
	      return false;
    }

    /**
     *  eq method.  Note it is stubbed out, and is to be completed as
     *  an exercise. 
     */	
    public boolean eq(Sortable P) {
	  return true;
    }
	
    /**
     *  A simple main to test running the program.
     */
    public static void main(String args[]) {
        SortedPrintTable t1 = new SortedPrintTable(10);
	
        t1.add(new Person("Cindy");
        t1.add(new Person("Chuck");
        t1.add(New Person("Linda");	 
        t1.add(new Person("Frieda");
        t1.add(new Person("Patty");

        t1.printTable();
    }
}
