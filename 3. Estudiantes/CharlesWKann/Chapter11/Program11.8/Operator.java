/*
 * TITLE: Program 11.8
 *
 * @(#)Operator.java 2002/07/21
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
 *   Purpose: This file shows how to design a simple arithmetic
 *   operator using classification.  To improve performance, only
 *   one instance of each operator type is created.
 */

/**
 *  The operator class.  Other than defining the static methods to
 *  retrieve the operator type, this method does nothing except define
 *  the abstract method "calculate" which all operators must define.
 */
abstract public class Operator {
    private static Hashtable operators;

    static {
        operators = new Hashtable();
        operators.put("+", new AddOperator());
        operators.put("-", new SubtractOperator());
    }

    public static Operator getOperator(String operatorSymbol) {
        return((Operator) operators.get(operatorSymbol));
    }

    public static boolean isOperator(String operatorSymbol) {
        return operators.containsKey(operatorSymbol);
    }

    abstract public double calculate(double d1, double d2);

    // Unit Test Application
    public static void main(String args[]) {
        // Calculate 3+5-2
        System.out.println( getOperator("-").calculate( 
                            getOperator("+").calculate(3.0, 5.0), 2.0));
    }
}

/**
 *  class to define an operator that does addition.
 */
class AddOperator extends Operator {
    public double calculate(double d1, double d2) {
        return (d1 + d2);
    }

    public String toString() {
        return "+";
    }
}

/**
 *   class to define an operator that does subtraction
 */
class SubtractOperator extends Operator {
    public double calculate(double d1, double d2) {
        return (d1 - d2);
    }

    public String toString() {
        return "-";
    }
}

