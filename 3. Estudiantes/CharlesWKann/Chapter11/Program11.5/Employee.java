/*
 * TITLE: Program 11.5
 *
 * @(#)Employee.java 2002/07/21
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
 *   Purpose: This design the composition equivalent to the Employee
 *   design in Program 11.2.  The main purpose is to show that the use
 *   of interfaces allows methods to be composited with the class, and 
 *   classification does not need to be used to specify that a method is needed.
 */


/**
 *  This class shows how to create an employee where the employee is 
 *  a basic "abstract" type.  In this case, the constructor for the employee
 *  is private, and so the employee can only be created by calling one of the
 *  static method to create a specific employee type.  This use of a static
 *  method to create a specific type of employee is sometimes called a "factory
 *  pattern".
 *
 *  Note that because we use a composition design, it is easy to change the 
 *  object from an hourly to a salaried employee without losing track of the
 *  employee object.
 */
class Employee extends Person{
    private PayType payType;
 
    private Employee(String name) {
        super(name);
    }

    public static Employee createHourlyEmployee(String name,
        float ratePerHour, float hoursWorked) {
        Employee employee = new Employee(name);    
        employee.payType = new HourlyPayType(ratePerHour, hoursWorked);
        return employee;
    }

    public static Employee createSalariedEmployee(String name, float weeklySalary) {
        Employee employee = new Employee(name);    
        employee.payType = new SalariedPayType(weeklySalary);
        return employee;
    }

    public void changeToSalaried(float weeklySalary) {
        payType = new SalariedPayType(weeklySalary);
    }

    public void changeToHourly(float ratePerHour, float hoursWorked) {
        payType = new HourlyPayType(ratePerHour, hoursWorked);
    }

    public float calculatePay() {
        return payType.calculatePay();
    }

    public static void main(String args[]) {
        Employee employee = createHourlyEmployee("Cindy", 12.23f, 40.00f);
        System.out.println(employee.calculatePay());
        // Here the employee is changed to a SalariedEmployee.  Note
        // that no new object is created.
        employee.changeToSalaried(2075.00f);
        System.out.println(employee.calculatePay());
    }
}

/**
 *  The base class for an employee.
 */
class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person(Person person) {
        this.name = person.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(String name) {
        return name;
    }
}

/**
 *  An interface that sets the employee to the correct type, and allows their pay
 *  to be calculated.
 */
interface PayType {
    public float calculatePay();
}

/**
 *  A class that specifies an hourly employee.
 */
class HourlyPayType implements PayType {
    private float ratePerHour;
    private float hoursWorked;

    public HourlyPayType(float ratePerHour, float hoursWorked) {
        this.ratePerHour = ratePerHour;
        this.hoursWorked = hoursWorked;
    }

    public float calculatePay() {
        return ratePerHour * hoursWorked;
    }
}

/**
 *  A class that specifies a salaried employee
 */
class SalariedPayType implements PayType {
    private float weeklySalary;

    public SalariedPayType(float weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    public float calculatePay() {
        return weeklySalary;
    }
}
