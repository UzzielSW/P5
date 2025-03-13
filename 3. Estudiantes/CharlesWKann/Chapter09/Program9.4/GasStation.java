 /** TITLE: Program 9.4a
 *
 * @(#)PumpListener.java 2002/07/21
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
 *    Purpose: This is the main method that implements the control object 
 *             for the GasStation simulation.
 */

public class GasStation {
    public static final int NUMBER_OF_CUSTOMERS = 10;

    public static void main(String args[]) {
        Pump pump1 = new Pump();
        Pump pump2 = new Pump();

        PumpManager pm = new PumpManager();
        pump1.addPumpListener(pm);
        pump2.addPumpListener(pm);

        pump1.startPump();
        pump2.startPump();

        Thread threadArray[] = new Thread[NUMBER_OF_CUSTOMERS];
        for (int i = 0; i < NUMBER_OF_CUSTOMERS; i++) {
            threadArray[i] = new Thread(new Car(i, pm));
            threadArray[i].start();
        }

        for (int i = 0; i < NUMBER_OF_CUSTOMERS; i++) {
            try  {
                threadArray[i].join();
            } catch(InterruptedException e) {
            }
        }

       // Print average time at the end of the simulation.
       System.out.println("Average time to get gas = " +
           Car.calcAverage());
    }
}
