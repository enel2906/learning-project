package org.example.app.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.exception.BusinessException;
import org.example.app.response.user.LogoutResponse;
import org.example.app.request.user.LogoutRequest;
import org.example.app.service.LikedInforService;
import org.example.app.service.PostService;
import org.example.app.service.SessionService;
import org.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.example.app.constant.ExceptionCode.UNKNOWN;

@Component

public class LogoutAPI extends CommonAPI<LogoutRequest, LogoutResponse> {
    private final SessionService sessionService;
    private final PostService postService;
    private final LikedInforService likedInforService;
    private final UserService userService;

    public LogoutAPI(SessionService sessionService, PostService postService, LikedInforService likedInforService, UserService userService){
        super(sessionService);
        this.sessionService = sessionService;
        this.postService = postService;
        this.likedInforService = likedInforService;
        this.userService = userService;
    }

    public LogoutResponse execute(LogoutRequest logoutRequest) {
        try{
            doExecute(logoutRequest);
            String token = logoutRequest.getToken();
            System.out.println(token);
            sessionService.remove(token);

            return new LogoutResponse();
        }catch(BusinessException e){
            return new LogoutResponse(e.getCode(), e.getMessage());
        }catch(Exception e){
            return new LogoutResponse(UNKNOWN.getCode(), e.getMessage());
        }
    }
}
