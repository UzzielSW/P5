/*
 * TITLE: Program 4.2
 *
 * @(#)tmp.c 2002/07/21
 * @author Charles W. Kann III
 *
 * Copyright (c) 2002 Charles W. Kann III
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
 *  This class shows a C program where the identifier and the 
 *  variable have different data types.  Because C does not check
 *  this, the program produces erroneous results.
 */
main()
{
    typedef union {
        int intVar;
        float floatVar;
    } NumType;

    NumType nt;
    nt.intVar = 1;
    nt.floatVar = nt.floatVar + 1;
    printf("nt.floatVar = %d\n", nt.floatVar);
}
