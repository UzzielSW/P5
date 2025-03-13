/*
 * TITLE: Program 3.1c
 *
 * @(#)BoundedBuffer 2002/07/21
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
 *  This class provides a shared buffer between a producer and
 *  consumer.  It allows the producer to leave values using the
 *  addToBuffer method, and the consumer to retrieve values
 *  using the takeFromBuffer method.
 */

public class BoundedBuffer {

    // Variables need to define the circular queue used
    // as the buffer
    private int values[];
    private int firstItem = 0;
    private int lastItem = 0;
    private int numberOfItems = 0;
    private int bufferSize;

    // variables to maintain the monitor state.
    public static final int EMPTY = 0;
    public static final int OPEN  = 1;
    public static final int FULL  = 2;
    private int bufferState = EMPTY;

    // Constructor for the BoundedBuffer.  Note that the
    // size of the buffer is set here based on the parameter
    // bufferSize
    public BoundedBuffer(int bufferSize) {
        this.bufferSize = bufferSize;
        values = new int[bufferSize];
    }

    /**
     * addToBuffer adds the item in the parameter 
     * to the buffer.
     */
    public synchronized void addToBuffer(int value) {

        // Pre-condition processing (method guard).
        while(! ((bufferState == EMPTY) ||
               (bufferState == OPEN ))) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        // Processing done to add item to buffer
        System.out.println("item " + value + " added to buffer");
        values[lastItem] = value;
        lastItem = (lastItem + 1) % bufferSize;
        numberOfItems = numberOfItems + 1;

        // Post-condition processing to change states
        if ((bufferState == OPEN) && (numberOfItems >= bufferSize)) {
            bufferState = FULL;
            notifyAll();
        }
        else if (bufferState == EMPTY) {
            bufferState = OPEN;
            notifyAll();
        }

    }

    /**
     * takeFromBuffer retrieves and removes an item  
     * from the buffer.
     */
    public synchronized int takeFromBuffer() {
        int value;

        // Pre-condition processing (method guard).
        while(! ((bufferState == FULL) ||
               (bufferState == OPEN)) ) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        // Processing done to take item from buffer
        value = values[firstItem];
        System.out.println("item " + value + " taken from buffer");
        firstItem = (firstItem + 1) % bufferSize;
        numberOfItems = numberOfItems - 1;

        // Post-condition processing to change states
        if ((bufferState == OPEN) && (numberOfItems <= 0)) {
            bufferState = EMPTY;
            notifyAll();
        }
        else if (bufferState == FULL) {
            bufferState = OPEN;
            notifyAll();
        }

        // Return the value taken from the buffer.
        return value;
    }

}
