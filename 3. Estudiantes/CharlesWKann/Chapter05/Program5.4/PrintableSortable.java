/*
 * TITLE: Program 5.4a
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
 *  This file defines 3 interfaces.
 *    1 - The Printable interface needs a print method.
 *    2 - The Sortable interface needs gt and eq methods.
 *    3 - The PrintableSortable inteface needs all 3 methods.
 *
 *  The PrintableSortable interface was defined by extending the 
 *  Printable and Sortable interfaces.  This was done to allow the
 *  PrintableSortable interface to be used with objects using
 *  any of the interfaces.  Otherwise objects would have to implement
 *  all the interfaces that they use.
 */  

interface Printable {
    public void print();
}

interface Sortable {
    public boolean gt(Sortable s);
    public boolean eq(Sortable s);
}
	
public interface PrintableSortable extends Printable, Sortable {
}
