package io.git.kadir.jersey.example.restservice.auth;

import java.util.Base64;

/**
 * @author akadir
 * Date: 2019-05-16
 * Time: 21:53
 */
public enum UserCredential {
    CORRECT("SergenYalcin", "Bjk1903"), WRONG("User", "Pass");

    private String userId;
    private String password;

    UserCredential(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getBasicAuthToken(){
        String usernameColonPassword = userId + ":" + password;
        String basicAuthPayload = "Basic " + Base64.getEncoder().encodeToString(usernameColonPassword.getBytes());
        return basicAuthPayload;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
}
