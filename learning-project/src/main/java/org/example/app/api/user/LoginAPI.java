package org.example.app.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.controller.SessionController;
import org.example.app.controller.UserController;
import org.example.app.exception.BusinessException;
import org.example.app.request.RequestData;
import org.example.app.response.ResponseData;
import org.example.app.response.user.LoginResponse;
import org.example.app.request.user.LoginRequest;

import static org.example.app.constant.ExceptionCode.*;
public class LoginAPI extends CommonAPI {
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
        String ipLogin = request.getIpLogin();
        String id = UserController.getInstance().accessAccount(username, password);
        if(SessionController.getInstance().countIdLogin(id) == 3){
            throw new BusinessException(REQUEST.getCode(), "this account is already login from 3 different IP");
        }
        int role = UserController.getInstance().getRole(id);
        String token = SessionController.getInstance().createSession(id, ipLogin, role);

        return new LoginResponse(token);
    }

    @Override
    protected RequestData parseRequestData(JsonObject jsonObject) {
        Gson gson = new Gson();
        return gson.fromJson(jsonObject, LoginRequest.class);
    }
}
