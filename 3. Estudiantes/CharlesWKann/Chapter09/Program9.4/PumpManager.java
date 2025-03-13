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

/**
 *    Purpose: This class is an adapter that listens to the pump objects, and
 *             when one is free, gives it to the car class.
 */

public class PumpManager implements PumpListener {
    private Vector customers = new Vector();
    private Vector pumps = new Vector();
    private int pumpsAvailable = 0;

    /**
     *  this method is called by a car thread to get a pump object that it can use.
     *  If no pump object is available, the car thread will wait until a pump manager
     *  has a pump available.  The car threads are notified in the order in which they
     *  begin waiting.
     */
    public Pump getPump() {
        Object notifyObject = new Object();
        synchronized (notifyObject) {
            synchronized(this) {
                    pumpsAvailable--;
                    if (pumpsAvailable < 0) {
                        customers.addElement(notifyObject);
                    }
                    else {
                        notifyObject = null;
                    }
            }

            if (notifyObject != null)
                try {
                    notifyObject.wait();
                } catch (InterruptedException e) {
            }
        }

        return (Pump)(pumps.remove(0));
    }

    /**
     *  This method is called by the Pump object when it becomes free (IE. it starts
     *  or a car leaves).  Note that this method must consider the case where a cusotmer
     *  (car) is or is not waiting.
     */
    public synchronized void pumpReady(PumpEvent e) {
        pumps.addElement(e.getPump());
        pumpsAvailable++;

        if (!customers.isEmpty()) {
            Object notifyObject = customers.remove(0);
            synchronized(notifyObject) {
                notifyObject.notify();
            }
        }
    }
}

