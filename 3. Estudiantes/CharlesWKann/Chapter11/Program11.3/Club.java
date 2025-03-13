/*
 * TITLE: Program 11.3
 *
 * @(#)Club.java 2002/07/21
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
 *   Purpose: This design shows how composition can be used to design
 *   an object that models a clubhouse  
 */

/**
 *  A class to define a name for a person.
 */
class Name {
    String firstName;
    String lastName;
}

/**
 *  A class to define a person.  A person has a name and age.
 */
class Person {
    Name name;
    int age;
}

/**
 *  Class to define a building.
 */
class Building {
    String streetAddress;
    String city;
    String state;
}

/**
 *  This class shows that a club has a clubhouse, a president, and a list of members.
 */
class Club {
    Person president;
    Building clubHouse;
    Person members[];
}
