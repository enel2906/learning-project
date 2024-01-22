package org.example.app.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.exception.BusinessException;
import org.example.app.response.user.LoginResponse;
import org.example.app.request.user.LoginRequest;
import org.example.app.service.LikedInforService;
import org.example.app.service.PostService;
import org.example.app.service.SessionService;
import org.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.example.app.constant.ExceptionCode.*;
@Component
public class LoginAPI extends CommonAPI<LoginRequest, LoginResponse> {
    private final SessionService sessionService;
    private final PostService postService;
    private final LikedInforService likedInforService;
    private final UserService userService;

    public LoginAPI(SessionService sessionService, PostService postService, LikedInforService likedInforService, UserService userService){
        super(sessionService);
        this.sessionService = sessionService;
        this.postService = postService;
        this.likedInforService = likedInforService;
        this.userService = userService;
    }


    public LoginResponse execute(LoginRequest loginRequest) {
        try{
            doExecute(loginRequest);
            String username = loginRequest.getUsername();
            String password = loginRequest.getPassword();
            String ipLogin = loginRequest.getIpLogin();
            String id = userService.findAccoount(username, password).getId();
            if(sessionService.countIpLogin(id) == 3){
                throw new BusinessException(REQUEST.getCode(), "this account is already login from 3 different IP");
            }
            int role = userService.getRole(id);
            String token = sessionService.createToken(id, ipLogin, role);

            return new LoginResponse(token);
        }catch(BusinessException e){
            return new LoginResponse(e.getCode(), e.getMessage());
        }catch(Exception e){
            return new LoginResponse(UNKNOWN.getCode(), e.getMessage());
        }
    }
}
