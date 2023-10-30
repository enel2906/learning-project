package org.example.app.request.user;

public class InforRequest {
    private String token;
    public InforRequest(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
