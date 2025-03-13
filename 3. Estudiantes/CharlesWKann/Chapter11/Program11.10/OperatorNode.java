/*
 * TITLE: Program 11.10
 *
 * @(#)OperatorNode.java 2002/07/21
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

import java.util.Hashtable;

/**
 *   Purpose: This file builds an expression tree using the nodes 
 *   defined in Program 11.9 (composition).  Note that this tree 
 *   is built using composition for the OperatorNode class.  While
 *   the program here can use either the composition or classification
 *   solution for the OperatorNode (in fact, with no changes), the 
 *   OperatorNode cannot be designed using classification with
 *   the operators from Program 11.8 or 11.9.
 */

interface Node {
    public void printTree();
    public double evaluate();
}

public class OperatorNode implements Node {
    Operator operator;
    Node left, right;
    public OperatorNode(String operatorSymbol, 
                        Node left, Node right) {
        this.operator = Operator.getOperator(operatorSymbol);
        this.left = left;
        this.right = right;
    }

    public void printTree() {
        System.out.print(" (");
        left.printTree();
        System.out.print(" " + operator.toString());
        right.printTree();
        System.out.print(" )");
    }

    public double evaluate() {
       return operator.calculate(left.evaluate(), right.evaluate());
    }

    public static void main(String args[]) {
        Node root;

        //  ((5-3)+1)
        root = new OperatorNode("+",
                   new OperatorNode("-",
                       new OperandNode(5), new OperandNode(3)),
                   new OperandNode(1));
       root.printTree();
       System.out.println(" = " + root.evaluate());

       // (5-(3+1))
       root = new OperatorNode("-",
                  new OperandNode(5), 
                  new OperatorNode("+",
                      new OperandNode(3), new OperandNode(1)));
       root.printTree();
       System.out.println(" = " + root.evaluate());
    }
}

class OperandNode implements Node {
    double value;
    public OperandNode(float value) {
        this.value = value;
    }

    public void printTree() {
        System.out.print(" " + value);
    }

    public double evaluate() {
        return value;
    }
}
