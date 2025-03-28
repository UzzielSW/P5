/*
 * TITLE: Program 3.2b
 *
 * @(#)Pump 2002/07/21
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
 *   This class implements the pump in the Gas Station 
 *   simulation.  It is a shared passive object that
 *   simply coordinates between the threads.  The calls on
 *   this class should go usePump->pumpGas->leave.
 */
class Pump {
    private static final int FREE = 0;
    private static final int BUSY = 1;
    private int state = FREE;

    /**
     *  Method to call when a Car first wishes to use a pump.
     *  It adds a 1/2 second to the simulated time in the 
     *  problem.
     */
    synchronized public void usePump() {
        try {
            // Pre-condition processing (guard)
            while(true) {
                if (state == FREE)
                    break;
                wait();
            }

            // Simulate pulling to the pump by waiting 1/2 second.
            Thread.sleep(500);  

            // Post-condition processing, change state.
            state = BUSY;
            notifyAll(); 
        } catch (InterruptedException e) {
        }
    }

    /**
     *   Simulate pumping the gas by waiting 5 seconds.
     */
    synchronized public void pumpGas() {
        try {
            // Pre-condition processing (guard)
            while(true) {
                if (state == BUSY)
                    break;
                wait();
            }

            // Simulate pumping gas by waiting 5 seconds.
            Thread.sleep(5000);

            // Post-condition processing, no change state needed.

        } catch (InterruptedException e) {
        }
    }

    /**
     *   Leave the pump, freeing it for the next customer.
     */
    synchronized public void leave() {
        try {
            // Pre-condition processing (guard)
            while(true) { 
                if (state == BUSY)
                    break;
                wait();
            }

            // Simulate leaving the pump by waiting 1/2 second.
            Thread.sleep(500); 

            // Post-condition processing, change state.
            state = FREE;
            notifyAll();
        } catch (InterruptedException e) {
        }
    }
}
