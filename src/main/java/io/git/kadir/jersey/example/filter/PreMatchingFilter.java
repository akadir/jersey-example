package io.git.kadir.jersey.example.filter;

import io.git.kadir.jersey.example.auth.Authenticator;
import io.git.kadir.jersey.example.util.Constants;
import io.git.kadir.jersey.example.util.MDCUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

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
        logger.info("requestPreMatch - To: {}", containerRequestContext.getUriInfo().getAbsolutePath().getPath());
        String userId = servletRequest.getHeader("userId");
        String password = servletRequest.getHeader("password");
        Authenticator.authenticate(userId, password, servletRequest);
    }
}
