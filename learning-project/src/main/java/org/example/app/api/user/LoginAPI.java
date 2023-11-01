package org.example.app.api.user;

import org.example.app.controller.TokenController;
import org.example.app.controller.UserController;
import org.example.app.response.user.LoginResponse;
import org.example.app.request.user.LoginRequest;
import org.example.app.exception.BusinessException;

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
               request.checkValidation();
               String username = request.getUsername();
               String password = request.getPassword();
               String id = UserController.getInstance().accessAccount(username, password);
               String token = TokenController.getInstance().createTokenAndAddToMap(id);
               return new LoginResponse(token);
           }catch (BusinessException e){
               return new LoginResponse(e.getCode(), e.getMessage());
           } catch (Exception e){
               return new LoginResponse(UNKNOWN, e.getMessage());
           }
    }
}
