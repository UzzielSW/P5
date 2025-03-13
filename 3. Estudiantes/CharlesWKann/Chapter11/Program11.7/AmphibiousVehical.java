/*
 * TITLE: Program 11.7
 *
 * @(#)Amphibious.java 2002/07/21
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
 *   Purpose: This shows the design of an amphibious vehicle using
 *   composition, where the multiple inheritence is dealt with using
 *   a state variable.  This design shows that often what is though of
 *   as multiple inheritence is just a state.
 */
abstract class Vehical {
    abstract public float getMaxSpeed();
}

class LandVehical extends Vehical {
    float maxSpeed;
    public float getMaxSpeed() {
        return maxSpeed;
    }
}

class WaterVehical extends Vehical {
    float maxSpeed;
    public float getMaxSpeed() {
        return maxSpeed;
    }
}

public class AmphibiousVehical {
    public static final int ON_WATER = 0;
    public static final int ON_LAND = 1;
    private int myState = ON_LAND;

    WaterVehical waterVehical = new WaterVehical();
    LandVehical landVehical = new LandVehical();


    public float getMaxSpeed() {
        if (myState == ON_WATER)
            return waterVehical.getMaxSpeed();
        else
            return landVehical.getMaxSpeed();
    }


}

