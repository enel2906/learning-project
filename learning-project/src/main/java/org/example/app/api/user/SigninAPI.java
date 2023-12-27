package org.example.app.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.request.user.SigninRequest;
import org.example.app.response.user.SigninResponse;
import org.example.app.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class SigninAPI extends CommonAPI<SigninRequest, SigninResponse> {
    private static final SigninAPI INSTANCE = new SigninAPI();

    private SigninAPI(){

    }
    public static SigninAPI getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public SigninResponse doExecute(SigninRequest request) throws Exception{
        String username = request.getUsername();
        String password = request.getPassword();
        String name = request.getName();
        int age = request.getAge();
        int role = request.getRole();
        String address = request.getAddress();
        UserService.getINSTANCE().addUser(username, password, name, age, role,address);
        return new SigninResponse("Sign in successfully");
    }

}
