/*
 * TITLE: Program 1.1
 *
 * @(#)Fibonacci.java 2002/07/21
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

import java.awt.*;
import java.awt.event.*;

/**
 *    Purpose:    This program illustrates the presence of threads in a Java
 *                program that uses a GUI.  A button is created that simply toggles
 *                the variable "stopProgram" to false, which should stop the 
 *                the program.  Once the button is created, the main method enters
 *                and infinite loop.  Since the loop does not explicitly call the
 *                the button, there appears to be no way for the program to exit.
 *                However when the button is pushed, the program does set the
 *                stopProgram to false, and the program exits, illustrating that
 *                the button is running in a different thread from the main method.
 */

public class Fibonacci  
{
    private static boolean stopProgram = false;

    public static void main(String argv[]) {
        Frame myFrame = new Frame("Calculate Fibinocci Numbers");
        List myList = new List(4);
        myFrame.add(myList, BorderLayout.CENTER);
        Button b1 = new Button("Stop Calculation");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopProgram = true;
            }
        });

        Button b2 = new Button("Exit");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        Panel p1 = new Panel();
        p1.add(b1);
        p1.add(b2);
        myFrame.add(p1, BorderLayout.SOUTH);
        myFrame.setSize(200, 300);
        myFrame.show();
		
        int counter = 2;
        while(true) {
            if (stopProgram)
                break;
            counter +=1;
            myList.add("Num = " + counter + "  Fib = " + 
            fibonacci(counter));
            myFrame.show();
        }

        // Note stopProgram cannot change value to true
        // in the above loop.  How does the program get
        // to this point?
        myList.add("Program Done");
    }

    public static int fibonacci(int NI) {
	    if (NI <= 1) return 1;
	    return fibonacci(NI - 1) + fibonacci(NI - 2);
    }
}

