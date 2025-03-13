/*
 * TITLE: Program 5.3e
 *
 * @(#)Polymorphism.java 2002/07/21
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
 *  This application implements the PrintTable storing both
 *  Person and Car objects.  To do this, the call to the print 
 *  method in the printAll method must be resolved at run time 
 *  reference the correct object type.  This is called Polymorphism.
 */  

public class Polymorphism 
{
    public static void main(String args[]) {
	    PrintTable T1 = new PrintTable(10);
            T1.add(new Person("Benoit"));
            T1.add(new Car(340));
            T1.add(new Person("Roget"));
            T1.add(new Car(200));
            T1.printAll();
    }
}

