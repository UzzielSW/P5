/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.restfull;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author BALA
 */

@Path("Address")
public class AddressResource {
    @Context
    private UriInfo context;

    /** Creates a new instance of AddressResource */
    public AddressResource() {
    }

    /**
     * Retrieves representation of an instance of com.restfull.AddressResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String getHtml() {
       return "Hello RESTful World";
    }

    /**
     * PUT method for updating or creating an instance of AddressResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void putHtml(String content) {
    }
}
