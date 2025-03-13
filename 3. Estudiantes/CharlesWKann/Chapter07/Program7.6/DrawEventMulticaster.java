/*
 * TITLE: Program 7.6
 *
 * @(#)Animator 2002/07/21
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

import java.util.*;

/** 
 *    Purpose:  This class implements a multicaster object.
 *              To protect from the race conditions and deadlock
 *              in the Java Event Model, the Vector of listeners
 *              is still made immutable.  However it is cloned
 *              in the add and remove listener methods.  Since
 *              these methods are called less frequently, the
 *              amount of work needed to clone the vector is
 *              significantly less.  Also since the Vector was
 *              internally synchronized, and the ArrayList is
 *              not, this class has less synchronization overhead.
 *              This will be a smaller impact than the cloning
 *              of the Vector, but will still make this implementation
 *              faster than the one in Program 7.5.
 */

public class DrawEventMulticaster implements DrawListener {
    ArrayList elementsToDraw = new ArrayList();

    /** Multicaster Constructer.  The multicaster takes two listeners,
      * which might be a single listener or collection, and appends them 
      * together.  Note that the constructor is private, and so is only
      * called from the static "add" and remove methods.  This method will then 
      * return the the Multicaster once it has been created, but once it
      * is specified it is immutable.  In this manner a Multicaster is 
      * is immutable.
      */
    protected DrawEventMulticaster(DrawListener a, DrawListener b) {
        if (a != null) {
            if (a instanceof DrawEventMulticaster) {
                elementsToDraw.addAll(((DrawEventMulticaster)a).elementsToDraw);
            }
            else {
                elementsToDraw.add(a);
            }
        }

        if (b != null) {
            if (b instanceof Collection) {
                elementsToDraw.addAll((Collection)b);
            }
            else {
                elementsToDraw.add(b);
            }
        }
    }

    /**
     *  Create a DrawListner by combining two other DrawListeners.
     *  Note that both DrawListeners can be objects or collection
     *  classes.
     */
    public static DrawListener add(DrawListener a, DrawListener b) {
        return new DrawEventMulticaster(a,b);    
    }


    /**
     *  Remove a DrawListener from a collection.
     */
    public static DrawListener remove(DrawListener a, DrawListener b) {
        DrawEventMulticaster dem = new DrawEventMulticaster(a, null);
        (dem.elementsToDraw).remove(b);
        return dem;
    }


   /**
    *  Call the draw method.  This will call the draw method for
    *  all DrawListeners that have been added, as if they are added
    *  they will be in the collection.
    */
    public void draw(DrawEvent e) {
        if (elementsToDraw != null) {
            Iterator i = elementsToDraw.iterator();
            while (i.hasNext()) {
                DrawListener dl = (DrawListener)i.next();
                dl.draw(e);
            }
        }
    }
}


