/*
 * TITLE: Program 11.4
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
 *   Purpose: This design shows how classification can be used to build
 *   all the data into a class for a club house.  The purpose is to illustrate
 *   that classification can be used for inappropriate designs.
 */

/**
 *  A class that defines a name, consisting of a first name and a last name.
 */
class Name {
    String firstName;
    String lastName;
}

/**
 *  A person object still has a name and age, it is just that the name comes
 *  to the object through inheritence.
 */
class Person extends Name {
    int age;
}

/**
 *  A building is still an address, but because of single inheritence we include
 *  the attributes of a person so that a club can be built from a Building.
 */
class Building extends Person {
    String streetAddress;
    String city;
    String state;
}

/**
 *  All the data needed for a club is now present except the list of members.  Note that
 *  this class has the same data as the class presented in 11.3.
 */
class Club extends Building {
    Person members[];
}
