/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.JaxRPC;

import javax.jws.WebService;

/**
 *
 * @author BALA
 */
@WebService
public class JaxRPCImple {
public String display(String name){
    return "Hello ! " + name;
}
}
