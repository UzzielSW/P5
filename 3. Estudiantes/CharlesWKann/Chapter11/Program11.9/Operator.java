/*
 * TITLE: Program 11.9
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
 *   operator using composition.  To improve performance, only
 *   one instance of each operator type is created.
 */

/**
 *  This class defines the operator.  Note that unlike program 11.8, 
 *  delegation is used to do the calculation.  An interface is created
 *  which defines how an operation works, and that interface is called
 *  from the operators calculate method.
 */
public class Operator {
    private static Hashtable operators;

    private String operatorSymbol;
    private Evaluator evaluator;

    static {
        operators = new Hashtable();
        operators.put("+", new Operator("+", new AddEvaluator()));
        operators.put("-", new Operator("-", new SubtractEvaluator()));
    }

    private Operator(String operatorSymbol, Evaluator evaluator) {
        this.operatorSymbol = operatorSymbol;
        this.evaluator = evaluator;
    }
   
    public static boolean isOperator(String operatorSymbol) {
        return operators.containsKey(operatorSymbol);
    }

    public static Operator getOperator(String operatorSymbol) {
        return((Operator) operators.get(operatorSymbol));
    }

    public double calculate(double d1, double d2) {
        return evaluator.calculate(d1, d2);
    }

    public String toString() {
        return (operatorSymbol);
    }
    // Unit Test Application
    public static void main(String args[]) {
        // Calculate 3+5-2
        System.out.println( getOperator("-").calculate( 
                            getOperator("+").calculate(3.0, 5.0), 2.0));
    }
}

/**
 *  interface for define how to do a calculation.
 */
interface Evaluator {
    public double calculate(double d1, double d2);
}

/**
 *  Class to do an add calculation
 */
class AddEvaluator implements Evaluator {
    public double calculate(double d1, double d2) {
        return (d1 + d2);
    }
}

/**
 *  Class to do a subtract calculation
 */
class SubtractEvaluator implements Evaluator {
    public double calculate(double d1, double d2) {
        return (d1 - d2);
    }
}

