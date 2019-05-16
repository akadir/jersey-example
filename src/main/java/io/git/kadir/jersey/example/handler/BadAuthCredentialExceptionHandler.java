package io.git.kadir.jersey.example.handler;

import io.git.kadir.jersey.example.entity.SimpleReturnObjectBuilder;
import io.git.kadir.jersey.example.exceptions.BadAuthenticationCredentialException;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author akarakoc
 * Date :   14.05.2019
 * Time :   09:17
 */
@Provider
public class BadAuthCredentialExceptionHandler implements ExceptionMapper<BadAuthenticationCredentialException> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Response toResponse(BadAuthenticationCredentialException e) {
        logger.error("An Error caught in BadAuthExHandler: ", e);
        JSONObject responseObject = new SimpleReturnObjectBuilder()
                .isSuccess(false)
                .error(e.getClass().getSimpleName())
                .errorMessage(e.getMessage())
                .buildJSONObject();
        return Response.status(401).entity(responseObject).type(MediaType.APPLICATION_JSON_TYPE).build();
    }
}
