package io.git.kadir.jersey.example.exceptions;

/**
 * @author akarakoc
 * Date :   14.05.2019
 * Time :   09:07
 */
public class BadAuthenticationCredentialException extends IllegalArgumentException {
    private static final String MESSAGE = "Incorrect user name or password";

    public BadAuthenticationCredentialException() {
        super(MESSAGE);
    }

    public BadAuthenticationCredentialException(Exception e) {
        super(MESSAGE, e);
    }

    public BadAuthenticationCredentialException(Throwable t) {
        super(MESSAGE, t);
    }
}
