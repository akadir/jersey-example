package io.git.kadir.jersey.example.filter;

import io.git.kadir.jersey.example.util.Constants;
import io.git.kadir.jersey.example.util.MDCUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import java.lang.reflect.Method;

/**
 * @author akarakoc
 * Date :   09.05.2019
 * Time :   14:10
 */
@Provider
public class RequestResponseFilter implements ContainerRequestFilter, ContainerResponseFilter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Context
    private HttpServletRequest servletRequest;

    @Context
    private ResourceInfo resourceInfo;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) {
        Method theMethod = resourceInfo.getResourceMethod();
        logger.info("requestMatched - Method: {}", theMethod.getName());
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) {
        Long duration = null;

        if (containerRequestContext.getPropertyNames().contains(Constants.ENTER_REST_SERVICE_KEY)) {
            long startTime = (long) containerRequestContext.getProperty(Constants.ENTER_REST_SERVICE_KEY);
            containerRequestContext.removeProperty(Constants.ENTER_REST_SERVICE_KEY);
            long endTime = System.currentTimeMillis();
            duration = (endTime - startTime);
        }

        logger.info("requestEnd - To: {} - Duration: {} ms - Response: {}", containerRequestContext.getUriInfo().getAbsolutePath().getPath(), duration, containerResponseContext.getEntity());
        MDCUtil.tearDownMDC();
    }
}
