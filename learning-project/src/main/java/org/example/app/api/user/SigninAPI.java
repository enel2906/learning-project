package org.example.app.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.exception.BusinessException;
import org.example.app.request.user.SigninRequest;
import org.example.app.response.user.SigninResponse;
import org.example.app.service.LikedInforService;
import org.example.app.service.PostService;
import org.example.app.service.SessionService;
import org.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.example.app.constant.ExceptionCode.UNKNOWN;

@Component

public class SigninAPI extends CommonAPI<SigninRequest, SigninResponse> {
    private final SessionService sessionService;
    private final PostService postService;
    private final LikedInforService likedInforService;
    private final UserService userService;

    public SigninAPI(SessionService sessionService, PostService postService, LikedInforService likedInforService, UserService userService){
        super(sessionService);
        this.sessionService = sessionService;
        this.postService = postService;
        this.likedInforService = likedInforService;
        this.userService = userService;
    }

    @Override
    public SigninResponse execute(SigninRequest signinRequest) {
        try{
            doExecute(signinRequest);
            String username = signinRequest.getUsername();
            String password = signinRequest.getPassword();
            String name = signinRequest.getName();
            int age = signinRequest.getAge();
            int role = signinRequest.getRole();
            String address = signinRequest.getAddress();
            userService.addUser(username, password, name, age, role,address);
            return new SigninResponse("Sign in successfully");
        }catch(BusinessException e){
            return new SigninResponse(e.getCode(), e.getMessage());
        }catch(Exception e){
            return new SigninResponse(UNKNOWN.getCode(), e.getMessage());
        }
    }

}
