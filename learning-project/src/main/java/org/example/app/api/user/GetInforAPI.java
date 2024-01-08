package org.example.app.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.model.User;
import org.example.app.request.user.InforRequest;
import org.example.app.response.user.InforResponse;
import org.example.app.service.LikedInforService;
import org.example.app.service.PostService;
import org.example.app.service.SessionService;
import org.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetInforAPI extends CommonAPI<InforRequest, InforResponse> {
    private final SessionService sessionService;
    private final PostService postService;
    private final LikedInforService likedInforService;
    private final UserService userService;

    public GetInforAPI(SessionService sessionService, PostService postService, LikedInforService likedInforService, UserService userService){
        super(sessionService);
        this.sessionService = sessionService;
        this.postService = postService;
        this.likedInforService = likedInforService;
        this.userService = userService;
    }

    @Override
    public InforResponse doExecute(InforRequest inforRequest) throws Exception{
        String token = inforRequest.getToken();
        String id = sessionService.getUserId(token);
        User user = userService.findByKey(id);
        return new InforResponse(user.getName(), user.getRole(), user.getAge());
    }
}