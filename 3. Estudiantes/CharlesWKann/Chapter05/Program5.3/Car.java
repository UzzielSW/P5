/*
 * TITLE: Program 5.3d
 *
 * @(#)Car.java 2002/07/21
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
 *  This application implements a PrintTable using Car objects.  
 *  Since the PrintTable was implemented using both Person objects
 *  and Car objects, it shows that the PrintTable class can be used
 *  generically with objects so long as those objects implement the 
 *  Printable interface.
 */  

public class Car implements Printable
{
    private int engineSize;
    public Car(int engineSize){
        this.engineSize = engineSize;
    }
    
    public void print(){
        System.out.println("My engine size is " + engineSize);
    }
	
    public static void main(String args[]) {
        PrintTable T1 = new PrintTable(10);
        T1.add(new Car(320));
        T1.add(new Car(150));
        T1.printAll();
    }
}
	
