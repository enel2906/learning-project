package org.example.app.api.userAPI;

import org.example.app.controller.TokenController;
import org.example.app.controller.UserController;
import org.example.app.model.User;
import org.example.app.reponse.userreponse.LoginReponse;
import org.example.app.request.userrequest.LoginRequest;
import org.example.app.util.Util;

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

        String id = UserController.getInstance().accessAccount(username, password);

        if(Util.isNull(id)){
            //TODO print
            return null;
        }

        String token = TokenController.getInstance().createTokenAndAddToMap(id);
        return new LoginReponse(token);
    }
}
