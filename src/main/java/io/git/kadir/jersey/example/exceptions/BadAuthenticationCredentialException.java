package io.git.kadir.jersey.example.exceptions;

/**
 * @author akarakoc
 * Date :   14.05.2019
 * Time :   09:07
 */
public class BadAuthenticationCredentialException extends IllegalArgumentException {
    private static final String MESSAGE = "Username or password is missing or invalid.";

    public BadAuthenticationCredentialException() {
        super(MESSAGE);
    }
}