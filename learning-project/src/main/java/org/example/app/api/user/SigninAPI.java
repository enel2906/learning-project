package org.example.app.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.controller.UserController;
import org.example.app.exception.BusinessException;
import org.example.app.request.RequestData;
import org.example.app.request.user.InforRequest;
import org.example.app.request.user.SigninRequest;
import org.example.app.response.ResponseData;
import org.example.app.response.user.SigninResponse;

import static org.example.app.constant.ExceptionCode.REQUEST;
import static org.example.app.constant.ExceptionCode.UNKNOWN;

public class SigninAPI extends CommonAPI{
    private static final SigninAPI INSTANCE = new SigninAPI();

    private SigninAPI(){

    }
    public static SigninAPI getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public ResponseData doExecute(RequestData requestData) throws Exception{
        SigninRequest request = (SigninRequest) requestData;
        String username = request.getUsername();
        String password = request.getPassword();
        String name = request.getName();
        int age = request.getAge();
        String role = request.getRole();

        UserController.getInstance().addUser(username, password, name, age, role);
        return new SigninResponse("Sign in successfully");
    }

    protected RequestData parseRequestData(JsonObject jsonObject) {
        Gson gson = new Gson();
        return gson.fromJson(jsonObject, SigninRequest.class);
    }
}
