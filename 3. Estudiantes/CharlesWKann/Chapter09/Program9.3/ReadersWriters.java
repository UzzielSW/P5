/*
 * TITLE: Program 9.3b
 *
 * @(#)ReadersWriters.java 2002/07/21
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
 *    Purpose: This class runs 50 reader threads and 3 writer threads to show the
 *    use of buffer in Program 9.3a.
 */

import java.util.*;

/**
 *  Main class that runs the buffer simulation
 */
public class ReadersWriters {
    public static void main(String args[]) {
        Buffer buffer = new Buffer();
        for (int i = 0; i < 50; i++)
            (new Thread(new Reader(buffer, i))).start();
        for (int i = 0; i < 3; i++)
            (new Thread(new Writer(buffer, i+50))).start();
    }
}

/**
 *  This class implements a reader thread.
 */
class Reader implements Runnable {
    private Buffer buffer;
    private int readerNumber;
    private Random random;

    public Reader(Buffer buffer, int readerNumber) {
        this.buffer = buffer;
        this.readerNumber = readerNumber;
        random = new Random(readerNumber);
    }

    public void run() {
        try {
            while(true) {
                Thread.sleep(random.nextInt(5000));
                buffer.read();
            }
        } catch(InterruptedException e) {
        }
    }
}

/**
 *  This class implements a writer thread.
 */
class Writer implements Runnable {
    private Buffer buffer;
    private int writerNumber;
    private Random random;

    public Writer(Buffer buffer, int writerNumber) {
        this.buffer = buffer;
        this.writerNumber = writerNumber;
        random = new Random(writerNumber);
    }

    public void run() {
        try {
            while(true) {
                Thread.sleep(random.nextInt(50000));
                buffer.write(new Object());
            }
        } catch(InterruptedException e) {
        }
    }
}

