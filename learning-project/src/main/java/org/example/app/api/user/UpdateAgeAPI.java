package org.example.app.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.model.User;
import org.example.app.request.user.UpdateAgeRequest;
import org.example.app.response.user.UpdateAgeResponse;
import org.example.app.service.LikedInforService;
import org.example.app.service.PostService;
import org.example.app.service.SessionService;
import org.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateAgeAPI extends CommonAPI<UpdateAgeRequest, UpdateAgeResponse> {

    private final SessionService sessionService;
    private final PostService postService;
    private final LikedInforService likedInforService;
    private final UserService userService;

    public UpdateAgeAPI(SessionService sessionService, PostService postService, LikedInforService likedInforService, UserService userService){
        super(sessionService);
        this.sessionService = sessionService;
        this.postService = postService;
        this.likedInforService = likedInforService;
        this.userService = userService;
    }

    public UpdateAgeResponse doExecute(UpdateAgeRequest request ) throws Exception{
        String token = request.getToken();
        int ageChange = request.getAgeChange();

        String id = sessionService.getUserId(token);
        userService.changeAgeOfUser(id, ageChange);
        User user = userService.findByKey(id);
        if(ageChange >= 0){
            return new UpdateAgeResponse("Already add "+ageChange+" to user: "+user.getName()+"!");
        }
        return new UpdateAgeResponse("Already minute "+(-1)*ageChange+" to user: "+user.getName()+"!");
    }
}
