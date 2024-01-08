package org.example.app.api.post;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.exception.BusinessException;
import org.example.app.request.post.AddNewPostRequest;
import org.example.app.request.post.AddNewPostRequest;
import org.example.app.response.post.AddNewPostResponse;
import org.example.app.service.LikedInforService;
import org.example.app.service.PostService;
import org.example.app.service.SessionService;
import org.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import static org.example.app.constant.PostType.*;
import static org.example.app.constant.Role.*;
import static org.example.app.constant.ExceptionCode.*;
@Component
public class AddNewPostAPI extends CommonAPI<AddNewPostRequest, AddNewPostResponse> {

    private final SessionService sessionService;
    private final PostService postService;
    private final UserService userService;

    public AddNewPostAPI(SessionService sessionService, PostService postService, UserService userService){
        super(sessionService);
        this.sessionService = sessionService;
        this.postService = postService;
        this.userService = userService;
    }

    @Override
    public AddNewPostResponse doExecute(AddNewPostRequest addNewPostRequest) throws Exception {
        String token = addNewPostRequest.getToken();
        String userId = sessionService.getUserId(token);
        int role = userService.getRole(userId);
        String type = addNewPostRequest.getType();
        if(!ListPostType.contains(type)){
            throw new BusinessException(REQUEST.getCode(), "Invalid type");
        }
        if(role == USER.getRole() && !type.equals(GREEN.getType())){
            throw new BusinessException(REQUEST.getCode(), "normal user only has type "+GREEN.getType());
        }
        String name = userService.getName(userId);
        String content = addNewPostRequest.getContent();
        String id = postService.addNewPost(userId, name, content, type);
        return new AddNewPostResponse("Add post successfully!");
    }

}
