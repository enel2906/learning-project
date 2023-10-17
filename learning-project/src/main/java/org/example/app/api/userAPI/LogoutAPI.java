package org.example.app.api.userAPI;

import org.example.app.controller.TokenController;
import org.example.app.controller.UserController;
import org.example.app.reponse.userreponse.LogoutReponse;
import org.example.app.request.userrequest.LogoutRequest;

public class LogoutAPI {
    private LogoutAPI(){

    }

    private static LogoutAPI INSTANCE = new LogoutAPI();
    public static LogoutAPI getInstance(){
        return INSTANCE;
    }

    public LogoutReponse execute(LogoutRequest logoutRequest){
        String token = logoutRequest.getToken();
        if(!TokenController.getInstance().isValidToken(token)){
            //TODO print
            return null;
        }
        TokenController.getInstance().removeToken(token);
        return new LogoutReponse();
    }
}
