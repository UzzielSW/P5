/* 
 * TITLE: Program 6.3
 *
 * @(#) tmp.c 2002/07/21
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
 *  This program shows a simple C program with minimal error checking.
 *  Note that the opening of the file is not checked, and the programmer
 *  relied on the fact that a null return from fgets implies an end of 
 *  file condition.  If the file does not open correctly, or some error
 *  other than an end of file stops the reading of the file, the program 
 *  is in error, but no contingency is made in case this happens.
 */  
#include <stdio.h>

main() 
{
    FILE *fp;
    char buf[80];
    fp = fopen("temp.dat", "r");
    while(fgets(buf, 80,fp))
    {
        printf("%s\n", buf);
    }
}
