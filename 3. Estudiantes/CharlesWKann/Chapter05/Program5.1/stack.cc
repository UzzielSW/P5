/*
 * TITLE: Program 5.1a
 *
 * @(#)Stack.cc 2002/07/21
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
 *  This source implements a template class in C++.  The template
 *  class defines generic operations on the data type ItemType.
 *  When this class used in a program, the ItemType is replaced
 *  by a specific data type (IE. float, int, etc) before the Stack
 *  class is compiled.
 *
 *  This is a generic class because it can be used with many other
 *  datatypes, but unlike generic objects in Java, the data types it
 *  can use are defined at compile time.
 */

template<class ItemType> class Stack
{
  public:
    Stack();
    void push(ItemType item);
    ItemType pop();
  private:
    int top;
    ItemType items[10];
};

template<class ItemType>
Stack<ItemType>::Stack() {
    top = 0;
}

template<class ItemType>
void Stack<ItemType>::push(ItemType item) {
    items[top] = item;
    top++;
}

template<class ItemType>
ItemType Stack<ItemType>::pop() {
    top--;
    return items[top] = item;
}

