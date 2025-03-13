/*
 * TITLE: Program 5.4b
 *
 * @(#)SortedPrintTable.java 2002/07/21
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
 *  This generic object sorts objects as they are entered into the
 *  table, and can be used to then print the table.  The add method
 *  uses the gt method from the Sortable interface to find the correct
 *  position to add the record, and the print method from the Printable 
 *  interface to print the records.
 *
 *  Note that deleting records has not been implemented, and left as an
 *  exercise.
 */  

public class SortedPrintTable {
    private PrintableSortable psArray[];
    private int currentSize;

    /** 
     *  Constructor method.  Create the table and
     *  set the currentSize to 0 to indicate the 
     *  table is empty.
     */
    public SortedPrintTable(int size) {
        psArray = new PrintableSortable[size];
        currentSize = 0;
    }

    /**
     *  delete method.  Remove an object from the table.
     *  Note this has been left to be implemented as an
     *  exercise.
     */  
    public void delete(PrintableSortable p) {
    }

    /** 
     *  add method.  Add an object to the table.
     *  Note that the gt method from the Sortable
     *  interface is used to find the place to insert
     *  this object.
     */
    public void add(PrintableSortable p) {

        // To handle an empty table.
        if (currentSize == 0)
        {
            psArray[0] = p;
            currentSize = 1;
            return;
        }

        // To handle a full table
        if (currentSize == psArray.length) {
            return;
        }

        // Start from the bottom of the table, and move items
        // out of the way until we find the place to insert.
        for (int i = currentSize-1 ; i >= 0; --i) {
            if (psArray[i].gt(p)) {
                psArray[i+1] = psArray[i];
                // Special  Case to handle insertion at the start
                // of the table.
                if (i == 0)
                    psArray[0] = p;
              }
              else {
                  // We have the right spot, so insert and stop the loop.
                  psArray[i+1] = p;
                  break;
              }
        }
        currentSize = currentSize + 1;
    }
	
    /**
     *  printTable method.  Go through the array and call the print
     *  method for each object stored.
     */
    public void printTable(){
        for (int i = 0; i < currentSize; ++i)
	      psArray[i].print();
    }
}
