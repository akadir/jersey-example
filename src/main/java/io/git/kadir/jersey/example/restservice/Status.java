/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.git.kadir.jersey.example.restservice;

import io.git.kadir.jersey.example.entity.SimpleReturnObjectBuilder;
import org.json.simple.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/isUp")
public class Status {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject isUp() {
        return new SimpleReturnObjectBuilder()
                .isSuccess(true)
                .data(true)
                .buildJSONObject();
    }

}
