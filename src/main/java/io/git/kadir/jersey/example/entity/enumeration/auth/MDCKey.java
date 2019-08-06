package io.git.kadir.jersey.example.entity.enumeration.auth;

/**
 * @author akarakoc
 * Date :   24.05.2019
 * Time :   18:25
 */
public enum MDCKey {
    REQUEST_ID("request-id"), REMOTE_ADDRESS("remote-address"), REMOTE_PORT("remote-port"), REMOTE_HOST("remote-host"),
    FORWARDED_ADDRESS("x-forwarded-for"), USER_ID("user-id"), HOST_IP("host-ip");

    private final String value;

    MDCKey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
