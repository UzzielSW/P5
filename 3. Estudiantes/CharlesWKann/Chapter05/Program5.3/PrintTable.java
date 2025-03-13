/*
 * TITLE: Program 5.3b
 *
 * @(#)PrintTable.java 2002/07/21
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
 *  The PrintTable object is a generic object that can store any type 
 *  of object, so long as that object implements the Printable interface.
 *  It relies on the promise of added objects to be Printable so that the
 *  call to the print method in the printAll method is valid.
 *
 *  Note only Printable objects can be added to the table because the
 *  printableArray is private and thus completely encapsulated in this
 *  class, and so the only way to modify it is through the add method.
 *  Since the add method only takes Printable objects, only Printable
 *  objects can be added to the table.
 */ 
 
public class PrintTable
{
    private Printable printableArray[];
    private int currentSize;
    
    /**
     *  Public constructor.  The size of the array to allocate (table
     *  size) must be passed in, as there is no default table size.
     */
    public PrintTable(int size) {
	printableArray = new Printable[size];
	currentSize = 0;
    }

    /**
     *  Add a Printable object to the table.
     */
    public void add(Printable a) {
        printableArray[currentSize] = a;
	currentSize = currentSize + 1;
    }

    /**
     *  Print all objects stored in the table.  Note we know that they
     *  are all Printable, so we know there will be a Print method 
     *  associated with each object.
     */
    public void printAll(){
        for (int i = 0; i < currentSize; ++i)
	    printableArray[i].print();
    }
}

