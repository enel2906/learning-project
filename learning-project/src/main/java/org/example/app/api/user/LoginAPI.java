package org.example.app.api.user;

import org.example.app.controller.TokenController;
import org.example.app.controller.UserController;
import org.example.app.request.Request;
import org.example.app.request.RequestData;
import org.example.app.request.user.InforRequest;
import org.example.app.response.ResponseData;
import org.example.app.response.user.LoginResponse;
import org.example.app.request.user.LoginRequest;
import org.example.app.exception.BusinessException;
import org.example.app.response.Response;

import static org.example.app.constant.ExceptionCode.*;

public class LoginAPI extends CommonAPI{
    private LoginAPI() {

    }

    private static final LoginAPI INSTANCE = new LoginAPI();

    public static LoginAPI getInstance() {
        return INSTANCE;
    }


    protected ResponseData doExecute(RequestData requestData) throws Exception{
        LoginRequest request = (LoginRequest) requestData;
        String username = request.getUsername();
        String password = request.getPassword();
        String id = UserController.getInstance().accessAccount(username, password);
        String token = TokenController.getInstance().createTokenAndAddToMap(id);

        return new LoginResponse(token);
    }


}
