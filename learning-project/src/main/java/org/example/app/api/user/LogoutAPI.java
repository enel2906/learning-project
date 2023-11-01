package org.example.app.api.user;

import org.example.app.controller.TokenController;
import org.example.app.request.RequestData;
import org.example.app.response.ResponseData;
import org.example.app.response.user.LogoutResponse;
import org.example.app.request.user.LogoutRequest;
import org.example.app.exception.BusinessException;

import static org.example.app.constant.ExceptionCode.*;

public class LogoutAPI extends CommonAPI{
    private LogoutAPI(){

    }

    private static LogoutAPI INSTANCE = new LogoutAPI();
    public static LogoutAPI getInstance(){
        return INSTANCE;
    }

    public ResponseData doExecute(RequestData requestData) throws Exception{
        LogoutRequest request = (LogoutRequest) requestData;
        String token = request.getToken();
        TokenController.getInstance().removeToken(token);

        return new LogoutResponse();
    }
}
