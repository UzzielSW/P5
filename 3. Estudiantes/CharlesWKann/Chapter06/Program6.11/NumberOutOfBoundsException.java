/* 
 * TITLE: Program 6.11a
 *
 * @(#) NumberOutOfBoundsException.java 2002/07/21
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
 *  This class file defines a exception when a number is set
 *  that is out of the range of valid numbers.  The number which
 *  actually caused the problem is to be stored so that the 
 *  program can use this invalid value latter in error messages,
 *  etc.
 *
 *  Note the large number of constructors needed here.  Because
 *  each variable can be used or not used, there are 2^n possible
 *  combinations of different types of constructor!
 *
 */

public class NumberOutOfBoundsException extends Exception {
    private int number;

    public NumberOutOfBoundsException() {
        number = 0;
    }

    public NumberOutOfBoundsException(String Message) {
        super(Message);
    }

    public NumberOutOfBoundsException(int number) {
        this.number = number;
    }

    public NumberOutOfBoundsException(String Message, int number) {
        super(Message);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
