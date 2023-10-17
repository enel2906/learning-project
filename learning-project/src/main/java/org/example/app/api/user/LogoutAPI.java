package org.example.app.api.user;

import org.example.app.controller.TokenController;
import org.example.app.response.user.LogoutResponse;
import org.example.app.request.user.LogoutRequest;

public class LogoutAPI {
    private LogoutAPI(){

    }

    private static LogoutAPI INSTANCE = new LogoutAPI();
    public static LogoutAPI getInstance(){
        return INSTANCE;
    }

    public LogoutResponse execute(LogoutRequest logoutRequest){
        String token = logoutRequest.getToken();
        if(!TokenController.getInstance().isValidToken(token)){
            //TODO print
            return null;
        }
        TokenController.getInstance().removeToken(token);
        return new LogoutResponse();
    }
}
