/*
 * TITLE: Program 11.1a
 *
 * @(#)Car.java 2002/07/21
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
 *   Purpose: This class shows building a car class using aggregation.
 */


/**
 *  A class to build a car class.
 */
class Driver {
}

/**
 *  A class to build a car class.
 */
class Tire implements Cloneable {
    protected Object clone() {
        return new Tire();
    }
}

/**
 *  An interface used to build the car class
 */
interface ServiceTimeCalculator {
    public int expectedTimeToService();
}

/**
 * A class to instantiate the interface.
 */
class myCarsCalculator implements ServiceTimeCalculator {
    public int expectedTimeToService(){
        return 0;
    }
}

/**
 *  This shows a class created using composition.  All of the different mechanisms for composition are 
 *  included:
 *        driver: Association
 *        modelName: Aggregation (using immutable objects)
 *        stc: composition using an interface
 *        engineSize: Aggregation (using a primative)
 *        tires[]: Aggregation (using an encapsulated variable)
 */
public class Car {
    private Driver driver;
    private String modelName();
    private ServiceTimeCalculator stc;
    private int engineSize;
    private static final int NUMBER_OF_TIRES = 4;
    private Tire tires[];

    /**
     *    public constructor.  It sets the values for the variables.  Note that the drive is association
     *    because the driver object passed was saved.  The tires are aggregation because new objects are 
     *    created that do not have scope outside of this object.  Finally methods can be composited using
     *    interfaces.
     */
    public Car(Driver driver, ServiceTimeCalculator stc, Tire[] tires) {
        this.driver = driver;
        this.stc = stc;
        this.engineSize = 350;
        for (int i = 0; i < NUMBER_OF_TIRES; i++) {
            this.tires[i] = (Tire) tires[i].clone();
        }
    }

    /**
     *  Accessor method for tires, which are aggregate variables using cloning of the object.
     */
    public void setTire(int tireNo, Tire tire) {
        this.tires[tireNo] = (Tire)tire.clone();
    }
    

    /**
     *  Accessor method  for modelName, which is an aggregate variable using an immutable object.
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

   /**
    *  Accessor which returns the model name.  Since the object is immutable, this does not violate
    *  the aggregate property of the object.
    */
    public String getModelName() {
        return modelName;
    }

    /**
     *  Accessor method for engineSize, which is an aggregate variable using a primative.
     */
    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    /**
     *  Accessor method to return engineSize.  Since it is a primitive, this does not violate the 
     *  aggregate property of the object.
     */
    public int getEngineSize() {
        return engineSize;
    }

    /**
     *  Accessor method for the driver, an association variable.  Note that the actual mutable object is
     *  stored, meaning that the object is shared with the calling method.
     */
    public Driver getDriver() {
        return driver;
    }

    /**
     *  Accessor method for driver, an association variable.  Note that the actual mutable object is returned.
     */
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
