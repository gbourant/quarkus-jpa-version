package com.gbourant;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

    @Inject
    MyService myService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String create() {
        return myService.createNewEntity();
    }

    @GET
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public String update() {
        return myService.editEntity();
    }

}