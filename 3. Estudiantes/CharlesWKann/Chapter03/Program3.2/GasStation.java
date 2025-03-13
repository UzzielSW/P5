/*
 * TITLE: Program 3.2c
 *
 * @(#)GasStation 2002/07/21
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
 *   GasStation control object, an object that creates the shared
 *   pump object, and the 10 cars that will use it.  When the 
 *   simulation is done, all car threads will be dead, and so
 *   by doing a join on each car thread at the end of the join
 *   simulation is done.  What this happens the average time
 *   at the pump is calculated.
 */
public class GasStation {
    static final int TOTAL_CARS = 10;

    public static void main(String args[]) {
        Thread carThreads[] = new Thread[TOTAL_CARS];
        try {
            // Create the monitor (passive object).
            Pump pump1 = new Pump();

            // Start all the Car threads
            for (int i = 0; i < TOTAL_CARS; i++) {
                Car car = new Car(i, pump1);
                (carThreads[i] = new Thread(car)).start();
            }

            // Now suspend and wait for simulation to finish.
            for (int i = 0; i < TOTAL_CARS; i++) {
                carThreads[i].join();
            }
       } catch (InterruptedException e) {
       }

       // Print average time at the end of the simulation.
       System.out.println("Average time to get gas = " +
           Car.calcAverage());
    }
}



