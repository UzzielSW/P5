/*
 * TITLE: Program 11.1
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
 *   Purpose: This file shows an abstract employee class being extended into
 *   two specific types of employees, an hourly employee and a salaried employee.
 *   Note that the employee extends a person.  A person is not abstract, and so 
 *   there can be person objects, but there cannot be employee objects.
 */

/**
 *  The base class to define a person.
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

    public String getName() {
        return name;
    }
}


/**
 *  The base class for an employee.  The data to define an employee, as well as the 
 *  methods that must be defined in the subclasses, are defined here.
 */
abstract class Employee extends Person {
    protected Employee(String name) {
        super(name);
    }
    
    protected Employee(Employee employee) {
        super(employee);
    }

    abstract public float calculatePay();

    public static void main(String args[]) {
        Employee employee = new HourlyEmployee("Cindy", 12.23f, 40.00f);
        System.out.println(employee.calculatePay());
        // Here the employee is changed to a SalariedEmployee.  Note
        // that a new object was created.
        employee = new SalariedEmployee(employee, 2075.00f);
        System.out.println(employee.calculatePay());
    }
}

/**
 *  A type of employee that is paid based on the number of hours worked.  To
 *  calculate the pay, the hours worked and the rate per hour need to be entered.
 */
class HourlyEmployee extends Employee {
    private float ratePerHour;
    private float hoursWorked;

    public HourlyEmployee(String name, float ratePerHour,
        float hoursWorked) {
        super(name);
        this.ratePerHour = ratePerHour;
        this.hoursWorked = hoursWorked;
    }

    public HourlyEmployee(Employee employee, float ratePerHour,
        float hoursWorked) {
        super(employee);
        this.ratePerHour = ratePerHour;
        this.hoursWorked = hoursWorked;
    }

    public float calculatePay() {
        return ratePerHour * hoursWorked;
    }
}

/**
 *  A type of employee that is paid a fixed amount each week.
 */
class SalariedEmployee extends Employee {
    private float weeklySalary;

    public SalariedEmployee(String name, float weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    public SalariedEmployee(Employee employee, float weeklySalary) {
        super(employee);
        this.weeklySalary = weeklySalary;
    }

    public float calculatePay() {
        return weeklySalary;
    }
}
