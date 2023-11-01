package org.example.app.response.user;

import org.example.app.response.Response;
import org.example.app.response.ResponseData;

public class LoginResponse extends ResponseData {
    private String token;

    public LoginResponse(int code, String message) {

    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginResponse(String token){
        this.token = token;
    }
}
