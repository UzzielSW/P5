/*
 * TITLE: Program 9.4c
 *
 * @(#)Pump.java 2002/07/21
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

import java.util.Vector;
import java.util.Enumeration;

/**
 *    Purpose: The pump is the event source object for the pump event.  It is also
 *             a monitor which controls the steps of the car thread once it pulls to 
 *             pump.  So this object combines aspects of two types of objects.
 *  
 */

class Pump {

    private Vector pumpListeners = new Vector();

    /**
     *  method to add a listener to the pump.
     */
    public void addPumpListener(PumpListener pl) {
        pumpListeners.addElement(pl);
    }

    /**
     *  method to remove a listener to the pump.
     */
    public void removePumpListener(PumpListener pl) {
        pumpListeners.removeElement(pl);
    }

    /**
     *  This is the process event method for the pump event.  It is called
     *  when the pump is free.
     */
    public void notifyPumpIsFree() {
        PumpEvent evt = new PumpEvent(this, this);
        Vector v;

        synchronized(this) {
             v = (Vector) pumpListeners.clone();
        }

        Enumeration e1 = v.elements();
        while (e1.hasMoreElements()) { 
            PumpListener P = (PumpListener)(e1.nextElement());
            P.pumpReady(evt);
         }
    }

    /**
     *  method that "turns the pump on".  It lets any listeners know that the pump
     *  is now available to use.
     */
    public void startPump() {
        notifyPumpIsFree();
    }

    /** 
     *  method to simulate pulling up to the pump.
     */
    public void usePump() {
        try {

            // Simulate pulling to the pump by waiting 1/2 second.
            Thread.sleep(500);  

        } catch (InterruptedException e) {
        }
    }

    /**
     *  method to simulate pumping the gas.
     */
    public void pumpGas() {
        try {

            // Simulate pumping gas by waiting 5 seconds.
            Thread.sleep(5000);

        } catch (InterruptedException e) {
        }
    }

    /**
     *  method to simulate leaving the pump.
     */
    public void leave() {
        try {
            // Simulate leaving the pump by waiting 1/2 second.
            Thread.sleep(500);
            notifyPumpIsFree();
        } catch (InterruptedException e) {
        }
    }
}
