/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.HelloSession.ejb;

import javax.ejb.Remote;

/**
 *
 * @author BALA
 */
@Remote
public interface EchoRemote {

    String Echo(String Display);
    
}
