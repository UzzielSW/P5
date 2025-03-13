/*
 * TITLE: Program 8.7a
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

import java.util.Random;
import java.util.Date;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
import animator.*;

/**
 *    This Class implements a thread that models a car at a Gas
 *    station in a simulation to calculate average wait time.
 *    It implements a thread that waits for a pump to become
 *    free, moves to the pump, and then leaves the pump.  
 *
 *    It has been modified from Program 3.2a in that the pump is
 *    now animated.
 */
class Car implements Runnable, DrawListener {
     private static int totalTime = 0,// Total time spent by all cars
                totalCars = 0;        // Total number of cars
     private int customerNumber;      // The customer number to set
                                      // Random value, and for
                                      // intermediate output.
     private Pump myPump;             // The pump the customer should use.

     private Animator animator;
     private Path myPath;

     private int parkingSpot;
     private static int ParkingSpots[] = {100, 175, 250, 325};
     private static int nextSpot = 0;

     private static int getFreeParkingSpot() {
         int returnValue = ParkingSpots[nextSpot];
         nextSpot = (nextSpot + 1) % ParkingSpots.length;
         return returnValue;    
     }

     /**
      *   Constructor:  Set the customerNumber and pump.
      */
     public Car(int customerNumber, Pump pump, Animator animator) {
         this.animator = animator;
         this.myPump = pump;
         this.customerNumber = customerNumber;
     }
     
     /**
      *   Static function to calculate average at the end of simulation.
      */
     public static float calcAverage() {
          return totalTime / totalCars;
     }

     /**
      *   This function implements the procedural mechanism for
      *   moving this object.  It is synchronized, and so in the
      *   synchronized block it sets up the path, and then calls
      *   wait to stop the thread until the movement on the path
      *   has completed.
      */
    private synchronized void move(int startX, int startY, int endX, 
        int endY,int numberOfSteps) {
        try {
            myPath = new StraightLinePath(startX, startY, endX, endY, numberOfSteps);
            wait();
        } catch(InterruptedException e) {
        }
    }
  
     /**
      *   The draw method allows this pump to be drawn as
      *   part of an animation.
      */
     public synchronized void draw(DrawEvent de) {
        // Get the Graphics to draw on.
        Graphics g = de.getGraphics();
        
        // Get where to draw.  If at end of path notify
        // the car.
        Point p = myPath.nextPosition();
        int x = (int)p.getX();
        int y = (int)p.getY();

        if (! myPath.hasMoreSteps()) {
                notify();
        }        

        // Draw the boxy car
        g.setColor(Color.red);
        g.fillRect(x, y, 100, 25);
        g.fillRect(x+20, y-20, 60, 20);
        g.setColor(Color.black);
        g.fillOval(x+10, y+20, 20, 20);
        g.fillOval(x+70, y+20, 20, 20);
        g.drawString("" + customerNumber, x+45, y);
     }

     /**
      *  Thread that implements the pump.
      */
     public void run() {
          // Declare variables need for simulation.
          final int WAIT_TIME = 80000;
          long startTime, endTime;
          Random random = new Random(customerNumber);
          int waitTime = random.nextInt(WAIT_TIME);

          // Wait a random amount of time before coming to pump.
          try {
              Thread.sleep(waitTime);
          } catch (InterruptedException e) {
          }
          startTime = (new Date()).getTime();

          // Add To animation
          parkingSpot = getFreeParkingSpot();
          myPath = new StraightLinePath(50,     // This just insures 
              parkingSpot, 50, parkingSpot, 1); // the object is at
                                                // a valid position
          animator.addDrawListener(this);

          // use the pump, pump the gas, and leave.
          System.out.println("Customer " + customerNumber +
                             " arrives at station");
          myPump.usePump();
           
          //Customer can now use the pump, so move them to the pump.
          move(50, parkingSpot, 150, parkingSpot, 10);
          move(150, parkingSpot, 175, 175, 10);
          move(175, 175, 325, 175, 10);

          System.out.println("Customer " + customerNumber +
                             " pumps gas");
          myPump.pumpGas();

          System.out.println("Customer " + customerNumber +
                             " leaves pump");
          myPump.leave();

          move(325, 175, 400, 175, 10);
          animator.removeDrawListener(this);
          
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
