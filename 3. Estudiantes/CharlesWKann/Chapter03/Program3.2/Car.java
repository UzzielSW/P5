/*
 * TITLE: Program 3.2a
 *
 * @(#)Car 2002/07/21
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

import java.util.*;

/**
 *    This Class implements a thread that models a car at a Gas
 *    station in a simulation to calculate average wait time.
 *    It implements a thread that waits for a pump to become
 *    free, moves to the pump, and then leaves the pump.
 */
class Car implements Runnable {
     private static int totalTime = 0,// Total time spent by all cars
                totalCars = 0;        // Total number of cars
     private int customerNumber;      // The customer number to set
                                      // Random value, and for
                                      // intermediate output.
     private Pump myPump;             // The pump the customer should use.

     /**
      *  Constructor:  Set the customerNumber and pump.
      */
     public Car(int customerNumber, Pump pump) {
         this.myPump = pump;
         this.customerNumber = customerNumber;
     }
     
     /**
      *  Static function to calculate average at the end of simulation.
      */
     public static float calcAverage() {
          return totalTime / totalCars;
     }

     /**
      *  Thread that implements the pump.
      */
     public void run() {
          // Declare variables need for simulation.
          final int WAIT_TIME = 30000;
          long startTime, endTime;
          Random random = new Random(customerNumber);
          int waitTime = random.nextInt(WAIT_TIME);

          // Wait a random amount of time before coming to pump.
          try {
              Thread.sleep(waitTime);
          } catch (InterruptedException e) {
          }

          // use the pump, pump the gas, and leave.
          System.out.println("Customer " + customerNumber +
                             " arrives at pump");
          startTime = (new Date()).getTime();
          myPump.usePump();

          System.out.println("Customer " + customerNumber +
                             " pumps gas");
          myPump.pumpGas();

          System.out.println("Customer " + customerNumber +
                             " leaves pump");
          myPump.leave();
          endTime = (new Date()).getTime();
          System.out.println("Time = " + (endTime - startTime));

          // Update the variables to calculate the average.  If
          // this is the last car, let the main() finish and print
          // the average.  Note that to use the static variables we
          // need to get the lock on the class.
          synchronized(Car.class) {
              totalTime += (endTime - startTime);
              totalCars++;
          }
     }
}
