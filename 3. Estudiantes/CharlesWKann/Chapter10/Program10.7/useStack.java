 * TITLE: Program 10.8
 *
 * @(#)UseStack 2002/07/21
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

import java.util.Stack;

/*
 *  Purpose: This program shows that defining a stack by 
 *           extending a Vector allows the user to misuse 
 *           the class.  The stack is a good example of
 *           why using classification for utility reuse
 *           is dangerous.  It also shows that it is 
 *           seductive, since extending a Vector appears to
 *           allow greater reuse.  It is only latter that
 *           the bill for that reuse becomes apparent.
 */
public class UseStack {
    public static void main(String args[]) {
        try {
            Stack stack = new Stack();
            stack.push("Element 1");

	    // the next statement is invalid for a stack
            stack.add(1, "Element 2"); 

	    // Note that the items are in the stack in the
	    // wrong order
            System.out.println(stack.pop());
            System.out.println(stack.pop());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
