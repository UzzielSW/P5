/*
 * TITLE: Program 9.4d
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

import java.util.Date;
import java.util.Random;

/**
 *    Purpose: This class implements the car thread, and maintains the total time
 *             that all cars take in the simulation.
 * 
 *             The class works as follows.  First the car waits a random amount of 
 *             time before begining the simulation.  Then it asks the pumpManager
 *             for a pump.  When a pump becomes available, the car then calls the
 *             methods as in the simulation in Chapter 3.
 */

public class Car implements Runnable {
     private static int totalTime = 0, // Total time spent by all cars
                        totalCars = 0; // Total number of cars
     private int customerNumber;
     private Pump myPump;
     private PumpManager pumpManager;

     /**
      *  public constructor.  This constructor sets the customerNumber for output,
      *  and sets the pumpManager so that it can talk to the adapter component.
      */
     public Car(int customerNumber, PumpManager pumpManager) {
         this.customerNumber = customerNumber;
         this.pumpManager = pumpManager;
     }

     /**
      *  at the end of the simulation, this method is used to calculate the 
      *  average time taken by all the cars in the simulation.
      */
     public static float calcAverage() {
          return totalTime / totalCars;
     }
 
     /**
      *  the run method, where the behavior of the car in the simulation is defined.
      */
     public void run() {
          final int WAIT_TIME = 30000;
          long startTime, endTime;
          Random random = new Random(customerNumber);
          int waitTime = random.nextInt(WAIT_TIME);

          // Wait a random amount of time before coming to pump.
          try {
              Thread.sleep(waitTime);
     
              startTime = (new Date()).getTime();
              // Wait for Pump Manager to tell me a pump is free.
              System.out.println("Customer " + customerNumber +
                                 " waiting in line");
              myPump = pumpManager.getPump();

              System.out.println("Customer " + customerNumber +
                                 " arrives at pump");
              myPump.usePump();

              System.out.println("Customer " + customerNumber +
                                 " pumps gas");
              myPump.pumpGas();

              System.out.println("Customer " + customerNumber +
                                 " leaves pump");
              myPump.leave();
              endTime = (new Date()).getTime();
              System.out.println("Time = " + (endTime - startTime));
              totalTime += (endTime - startTime);
              totalCars++;

          } catch (InterruptedException e) {
          }
     }
}

