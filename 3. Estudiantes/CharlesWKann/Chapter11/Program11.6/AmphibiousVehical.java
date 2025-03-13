/*
 * TITLE: Program 11.6
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
 *   Purpose: This shows the "obvious" design of an amphibious vehicle
 *   as extending both a LandVehical and a WaterVehical.  
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

public class AmphibiousVehical extends LandVehical, WaterVehical {
}

