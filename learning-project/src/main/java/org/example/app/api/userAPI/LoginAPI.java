package org.example.app.api.userAPI;

import org.example.app.controller.UserController;
import org.example.app.reponse.userreponse.LoginReponse;
import org.example.app.request.userrequest.LoginRequest;

public class LoginAPI {
    private LoginAPI() {

    }

    private static final LoginAPI INSTANCE = new LoginAPI();

    public static LoginAPI getInstance() {
        return INSTANCE;
    }

    public LoginReponse execute(LoginRequest request){
        String username = request.getUsername();
        String password = request.getPassword();

        String token = UserController.getInstance().accessAccount(username, password);
        return new LoginReponse(token);
    }

}
