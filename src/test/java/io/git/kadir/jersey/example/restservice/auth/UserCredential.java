package io.git.kadir.jersey.example.restservice.auth;

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

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
}
