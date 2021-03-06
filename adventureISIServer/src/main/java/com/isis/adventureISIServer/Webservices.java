/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isis.adventureISIServer;

import com.isis.adventureISIServer.generated.PallierType;
import com.isis.adventureISIServer.generated.ProductType;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;

/**
 *
 * @author dell
 */
@Path("generic")
public class Webservices {

    Services services;

    public Webservices() {
        services = new Services();
    }

    @GET
    @Path("world")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getWorld(@Context HttpServletRequest request) throws JAXBException {
        String username = request.getHeader("X-user");
        return Response.ok(services.getWorld(username)).build();

    }

    @PUT
    @Path("/product")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addproduct(ProductType produit, @Context HttpServletRequest request) throws JAXBException {
        String pseudo = request.getHeader("X-user");
        services.updateProduct(pseudo, produit);
    }

    @PUT
    @Path("/manager")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addmanager(PallierType newmanager, @Context HttpServletRequest request) throws JAXBException {
        String pseudo = request.getHeader("X-user");
        services.updateManager(pseudo, newmanager);
    }
}
