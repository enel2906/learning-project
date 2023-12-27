package org.example.app.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.exception.BusinessException;
import org.example.app.response.user.LoginResponse;
import org.example.app.request.user.LoginRequest;
import org.example.app.service.SessionService;
import org.example.app.service.UserService;

import static org.example.app.constant.ExceptionCode.*;
public class LoginAPI extends CommonAPI<LoginRequest, LoginResponse> {
    private LoginAPI() {

    }
    private static final LoginAPI INSTANCE = new LoginAPI();

    public static LoginAPI getInstance() {
        return INSTANCE;
    }


    public LoginResponse doExecute(LoginRequest request) throws Exception{
        String username = request.getUsername();
        String password = request.getPassword();
        String ipLogin = request.getIpLogin();
        String id = UserService.getINSTANCE().findAccoount(username, password).getId();
        if(SessionService.getINSTANCE().countIpLogin(id) == 3){
            throw new BusinessException(REQUEST.getCode(), "this account is already login from 3 different IP");
        }
        int role = UserService.getINSTANCE().getRole(id);
        String token = SessionService.getINSTANCE().createToken(id, ipLogin, role);

        return new LoginResponse(token);
    }
}
