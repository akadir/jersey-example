package io.git.kadir.jersey.example.filter;

import io.git.kadir.jersey.example.auth.Authenticator;
import io.git.kadir.jersey.example.exceptions.BadAuthenticationCredentialException;
import io.git.kadir.jersey.example.util.Constants;
import io.git.kadir.jersey.example.util.MDCUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author akarakoc
 * Date :   09.05.2019
 * Time :   18:05
 */
@Provider
@PreMatching
public class PreMatchingFilter implements ContainerRequestFilter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Context
    private HttpServletRequest servletRequest;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) {
        containerRequestContext.setProperty(Constants.ENTER_REST_SERVICE_KEY, System.currentTimeMillis());
        MDCUtil.setUpMDC(servletRequest);

        String[] credential = getCredentialsFromAuthorizationHeader();

        String userId = credential[0];
        String password = credential[1];
        logger.info("requestPreMatch - with userId {} - to: {}", userId, containerRequestContext.getUriInfo().getAbsolutePath());
        Authenticator.authenticate(userId, password, servletRequest);
        MDCUtil.addUserId(userId);
    }

    private String[] getCredentialsFromAuthorizationHeader(){
        String[] values;
        final String authorization = servletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorization != null && authorization.toLowerCase().startsWith("basic")) {
            // Authorization: Basic base64credentials
            String base64Credentials = authorization.substring("Basic".length()).trim();
            byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(credDecoded, StandardCharsets.UTF_8);
            // credentials = username:password
            values = credentials.split(":", 2);
        } else {
            throw new BadAuthenticationCredentialException();
        }
        return values;
    }
}
