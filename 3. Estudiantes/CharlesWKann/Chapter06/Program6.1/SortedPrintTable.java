/*
 * TITLE: Program 6.1 (Extra file).
 *
 * @(#)PrintableSortable.java 2002/07/21
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
 *  This is the same SortedPrintTable as in Program 5.4
 *  It is included here so that Program 6.1 will compile correctly.
 */  

public class SortedPrintTable {
    private PrintableSortable psArray[];
    private int currentSize;

    public SortedPrintTable(int size) {
        psArray = new PrintableSortable[size];
        currentSize = 0;
    }

    //  Method: delete
    //  Purpose:
    public void delete(PrintableSortable p) {
    }


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
	
    public void printTable(){
        for (int i = 0; i < currentSize; ++i)
	      psArray[i].print();
    }
}
