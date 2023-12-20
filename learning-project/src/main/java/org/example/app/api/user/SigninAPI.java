package org.example.app.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.controller.UserController;
import org.example.app.request.RequestData;
import org.example.app.request.user.SigninRequest;
import org.example.app.response.ResponseData;
import org.example.app.response.user.SigninResponse;

import java.util.ArrayList;
import java.util.List;

public class SigninAPI extends CommonAPI {
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
        int role = request.getRole();
        String address = request.getAddress();
        List<String> ipLogins = new ArrayList<>();
        UserController.getInstance().addUser(username, password, name, age, role,address, ipLogins);
        return new SigninResponse("Sign in successfully");
    }

    protected RequestData parseRequestData(JsonObject jsonObject) {
        Gson gson = new Gson();
        return gson.fromJson(jsonObject, SigninRequest.class);
    }
}
