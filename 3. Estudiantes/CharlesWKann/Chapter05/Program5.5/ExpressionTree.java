/*
 * TITLE: Program 5.5
 *
 * @(#) ExpressionTree.java 2002/07/21
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
 *  This application implements the SortedPrintTable for a Person object.
 *  Note to use a Person object in the table, the Person object extended
 *  PrintableSortable, and then defines the print, gt, and eq methods.
 */  


/**
 *  The Node interface allows for the generic definition of objects that
 *  will implement printTree and evaluate methods.  This allows the tree
 *  object to store nodes without worrying about whether these nodes are
 *  operators or operands.
 */
interface Node {
    public void printTree();
    public float evaluate();
}

/**
 *  An OperatorNode is a tree node which stores an operator.  An operator needs
 *  both left and right children (all operators are binary).  When printing or 
 *  evaluating the node, the printTree or evaluate methods are called on the 
 *  children, and the result handed back to the calling method.
 */
class OperatorNode implements Node {
    char operator;
    Node left, right;
    public OperatorNode(char operator, Node left, Node right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public void printTree() {
        System.out.print(" (");
        left.printTree();
        System.out.print(" " + operator);
        right.printTree();
        System.out.print(" )");
    }

    public float evaluate() {
        if (operator == '+')
            return left.evaluate() + right.evaluate();
        else if (operator == '-')
            return left.evaluate() - right.evaluate();
        else
            return 0;  // Invalid condition
    }
}

/**
 *  An OperandNode is a leaf node which stores a value.  It has no children, and
 *  thus the printTree and evaluate methods simply return or print the value 
 *  currently stored in the node.
 */
class OperandNode implements Node {
    float value;
    public OperandNode(float value) {
        this.value = value;
    }

    public void printTree() {
        System.out.print(" " + value);
    }

    public float evaluate() {
        return value;
    }
}

/**
 *  ExpressTree is the driver program that shows how the expression tree program works.
 *  It builds trees of operator and operand nodes, and then prints and evaluates
 *  those trees.
 */
public class ExpressionTree {
    public static void main(String args[]) {
        Node root;

        //  ((5-3)+1)
        root = new OperatorNode('+',
                   new OperatorNode('-',
                       new OperandNode(5), new OperandNode(3)),
                   new OperandNode(1));
       root.printTree();
       System.out.println(" = " + root.evaluate());

       // (5-(3+1))
       root = new OperatorNode('-',
                  new OperandNode(5), 
                  new OperatorNode('+',
                      new OperandNode(3), new OperandNode(1)));
       root.printTree();
       System.out.println(" = " + root.evaluate());
    }
}
