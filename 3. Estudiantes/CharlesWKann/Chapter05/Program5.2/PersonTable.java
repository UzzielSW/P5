/*
 * TITLE: Program 5.2
 *
 * @(#)PersonTable.java 2002/07/21
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
 *  This source implements a table of people built on an unsorted
 *  array.  Person records are added to the table, and when the program
 *  has finished running, the records are printed out by calling the 
 *  printAll method in the table, which in turn calls the print method in
 *  each Person object.  Note that this is an instance of programming to 
 *  a fact, as the array people only stores Person objects, and the print
 *  method is defined as part of the Person object.
 */

class Person
{
    private String name;
    public Person(String name){
        this.name = name;
    }
      
    public void print(){
        System.out.println("My Name is " + name);
    }
}
	
public class PersonTable
{
    private Person people[];
    private int currentSize;

    public PersonTable(int size) {
        people = new Person[size];
        currentSize = 0;
    }
	
    public void add(Person person) {
        people[currentSize] = person;
        currentSize = currentSize + 1;
    }
	
    public void printAll(){
        for (int i = 0; i < currentSize; ++i)
            people[i].print();
        }
	
    public static void main(String args[]) {
        PersonTable table = new PersonTable(10);
        table.add(new Person("Benoit"));
        table.add(new Person("Roget"));
        table.printAll();
    }
}

