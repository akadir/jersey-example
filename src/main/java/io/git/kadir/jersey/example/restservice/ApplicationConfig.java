package io.git.kadir.jersey.example.restservice;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("jersey-example/api")
public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig() {
        register(JacksonJsonProvider.class);
        packages("io.git.kadir.jersey.example.restservice", "io.git.kadir.jersey.example.filter", "io.git.kadir.jersey.example.handler");
    }
}
