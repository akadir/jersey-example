package io.git.kadir.jersey.example.auth;

import io.git.kadir.jersey.example.exceptions.BadAuthenticationCredentialException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author akadir
 * Date: 2019-05-15
 * Time: 20:37
 */
public class Authenticator {
    private static final Logger logger = LoggerFactory.getLogger(Authenticator.class);

    private Authenticator() {
    }

    public static void authenticate(String userId, String password, HttpServletRequest servletRequest) {
        if (userId.equals("SergenYalcin") && password.equals("Bjk1903")) {
            servletRequest.getSession().setAttribute("userId", userId);
            logger.info("User authenticated | userId: {} | password {}", userId, password);
        } else {
            throw new BadAuthenticationCredentialException();
        }
    }
}
