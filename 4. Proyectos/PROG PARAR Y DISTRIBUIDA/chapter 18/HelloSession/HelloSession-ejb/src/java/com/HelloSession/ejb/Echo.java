/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.HelloSession.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author BALA
 */
@Stateless
public class Echo implements EchoRemote {

    public String Echo(String Display) {
        return "Hello : " + Display;
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
 
}
