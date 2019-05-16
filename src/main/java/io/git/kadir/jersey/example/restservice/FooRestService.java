/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.git.kadir.jersey.example.restservice;

import io.git.kadir.jersey.example.entity.SimpleReturnObjectBuilder;
import io.git.kadir.jersey.example.service.FooService;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author akarakoc
 */
@Path("/")
public class FooRestService {
    private FooService fooService = new FooService();

    @GET
    @Path("/foo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFoo(@QueryParam("bar") String bar, @Context HttpServletRequest request) throws Exception {
        String result = fooService.getFoo(bar);

        JSONObject response = new SimpleReturnObjectBuilder()
                .isSuccess(true)
                .data(result)
                .buildJSONObject();
        return Response.ok(response, MediaType.APPLICATION_JSON).build();
    }
}
