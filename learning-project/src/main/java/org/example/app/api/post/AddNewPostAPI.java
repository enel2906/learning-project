package org.example.app.api.post.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.controller.PostController;
import org.example.app.controller.SessionController;
import org.example.app.controller.UserController;
import org.example.app.exception.BusinessException;
import org.example.app.request.RequestData;
import org.example.app.request.user.AddNewPostRequest;
import org.example.app.response.ResponseData;
import org.example.app.response.user.AddNewPostResponse;

import static org.example.app.constant.PostType.*;
import static org.example.app.constant.Role.*;
import static org.example.app.constant.ExceptionCode.*;
public class AddNewPostAPI extends CommonAPI {
    private AddNewPostAPI(){

    }
    private static AddNewPostAPI INSTANCE = new AddNewPostAPI();

    public static AddNewPostAPI getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public ResponseData doExecute(RequestData requestData) throws Exception {
        AddNewPostRequest addNewPostRequest = (AddNewPostRequest) requestData;
        String token = addNewPostRequest.getToken();
        String userId = SessionController.getInstance().getUserId(token);
        int role = UserController.getInstance().getRole(userId);
        String type = addNewPostRequest.getType();
        if(!ListPostType.contains(type)){
            throw new BusinessException(REQUEST.getCode(), "Invalid type");
        }
        if(role == USER.getRole() && !type.equals(GREEN.getType())){
            throw new BusinessException(REQUEST.getCode(), "normal user only has type "+GREEN.getType());
        }
        String name = UserController.getInstance().getName(userId);
        String content = addNewPostRequest.getContent();
        String id = PostController.getINSTANCE().addNewPost(userId, name, content, type);
        return new AddNewPostResponse("Add post successfully!");
    }

    @Override
    protected RequestData parseRequestData(JsonObject jsonObject) {
        Gson gson = new Gson();
        return gson.fromJson(jsonObject, AddNewPostRequest.class);
    }
}
