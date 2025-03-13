/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.WebWS;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author BALA
 */
@WebService()
public class MyWebService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "display")
    public String display(@WebParam(name = "name")
    String name) {
        //TODO write your implementation code here:
      return "Hello ! "+ name;
    }

}
