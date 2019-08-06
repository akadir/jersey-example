package io.git.kadir.jersey.example.handler;

import io.git.kadir.jersey.example.entity.SimpleReturnObjectBuilder;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author akarakoc
 * Date :   13.05.2019
 * Time :   10:50
 */
@Provider
public class GenericExceptionHandler implements ExceptionMapper<Exception> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Response toResponse(Exception e) {
        logger.error("An error caught in generic exception handler: ", e);
        int statusCode = getHttpStatus(e);
        JSONObject responseObject = new SimpleReturnObjectBuilder()
                .isSuccess(false)
                .error(e.getClass().getSimpleName())
                .errorMessage(e.getMessage())
                .buildJSONObject();
        return Response.status(statusCode).entity(responseObject).type(MediaType.APPLICATION_JSON_TYPE).build();
    }

    private int getHttpStatus(Exception ex) {
        if(ex instanceof WebApplicationException) {
            return ((WebApplicationException)ex).getResponse().getStatus();
        } else {
            return Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        }
    }
}
