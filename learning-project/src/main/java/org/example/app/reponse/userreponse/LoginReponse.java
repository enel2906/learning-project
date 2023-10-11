package org.example.app.reponse.userreponse;

public class LoginReponse {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginReponse(String token){
        this.token = token;
    }
}
