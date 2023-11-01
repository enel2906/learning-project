package org.example.app.api.user;

import org.example.app.controller.UserController;
import org.example.app.exception.BusinessException;
import org.example.app.request.user.SigninRequest;
import org.example.app.response.user.SigninResponse;

import static org.example.app.constant.ExceptionCode.REQUEST;
import static org.example.app.constant.ExceptionCode.UNKNOWN;

public class SigninAPI {
    private static final SigninAPI INSTANCE = new SigninAPI();

    private SigninAPI(){

    }
    public static SigninAPI getINSTANCE() {
        return INSTANCE;
    }

    public SigninResponse execute(SigninRequest request){
        try{
            request.checkValidation();
            String username = request.getUsername();
            String password = request.getPassword();
            String name = request.getName();
            int age = request.getAge();
            String role = request.getRole();

            UserController.getInstance().addUser(username, password, name, age, role);
            return new SigninResponse("Sign in successfully");
        }catch (BusinessException e){
            return new SigninResponse(REQUEST, e.getMessage());
        }catch (Exception e){
            return new SigninResponse(UNKNOWN, e.getMessage());
        }
    }
}
