package org.example.app.api.post;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.exception.BusinessException;
import org.example.app.request.post.AddNewPostRequest;
import org.example.app.request.post.AddNewPostRequest;
import org.example.app.response.post.AddNewPostResponse;
import org.example.app.service.PostService;
import org.example.app.service.SessionService;
import org.example.app.service.UserService;

import static org.example.app.constant.PostType.*;
import static org.example.app.constant.Role.*;
import static org.example.app.constant.ExceptionCode.*;
public class AddNewPostAPI extends CommonAPI<AddNewPostRequest, AddNewPostResponse> {
    private AddNewPostAPI(){

    }
    private static AddNewPostAPI INSTANCE = new AddNewPostAPI();

    public static AddNewPostAPI getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public AddNewPostResponse doExecute(AddNewPostRequest addNewPostRequest) throws Exception {
        String token = addNewPostRequest.getToken();
        String userId = SessionService.getINSTANCE().getUserId(token);
        int role = UserService.getINSTANCE().getRole(userId);
        String type = addNewPostRequest.getType();
        if(!ListPostType.contains(type)){
            throw new BusinessException(REQUEST.getCode(), "Invalid type");
        }
        if(role == USER.getRole() && !type.equals(GREEN.getType())){
            throw new BusinessException(REQUEST.getCode(), "normal user only has type "+GREEN.getType());
        }
        String name = UserService.getINSTANCE().getName(userId);
        String content = addNewPostRequest.getContent();
        String id = PostService.getINSTANCE().addNewPost(userId, name, content, type);
        return new AddNewPostResponse("Add post successfully!");
    }

}
