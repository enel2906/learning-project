package org.example.app.api.userAPI;

public class LoginAPI {
    private LoginAPI(){

    }
    private static final LoginAPI INSTANCE = new LoginAPI();
    public static LoginAPI getInstance(){return INSTANCE;}


}
