package org.example.app.api.user;

import org.example.app.constant.ExceptionCode;
import org.example.app.controller.TokenController;
import org.example.app.controller.UserController;
import org.example.app.response.user.InforResponse;
import org.example.app.response.user.LoginResponse;
import org.example.app.request.user.LoginRequest;
import org.example.app.util.BusinessException;
import org.example.app.util.OtherException;
import org.example.app.util.Util;

import static org.example.app.constant.ExceptionCode.*;

public class LoginAPI {
    private LoginAPI() {

    }

    private static final LoginAPI INSTANCE = new LoginAPI();

    public static LoginAPI getInstance() {
        return INSTANCE;
    }

    public LoginResponse execute(LoginRequest request){
           try{
               String username = request.getUsername();
               String password = request.getPassword();
               if (password.length() < 6 || Util.isNotContainCapitalLetter(username)) {
                   throw new BusinessException(REQUEST, "Wrong Data Format");
               }
               String id = UserController.getInstance().accessAccount(username, password);
               if (Util.isNull(id)) {
                   throw new BusinessException(INVALID, "Invalid token");
               }
               String token = TokenController.getInstance().createTokenAndAddToMap(id);
               return new LoginResponse(token);
           }catch (BusinessException e){
               return new LoginResponse(e.getCode(), e.getMessage());
           } catch (Exception e){
               return new LoginResponse(UNKNOWN, e.getMessage());
           }
    }
}
