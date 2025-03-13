/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.JaxRPC;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
/**
 *
 * @author BALA
 */

@WebService
@SOAPBinding(style=SOAPBinding.Style.RPC)
public interface JaxRPC {
public String display(String name);
}
