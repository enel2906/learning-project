package org.example.app.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.controller.PostController;
import org.example.app.controller.SessionController;
import org.example.app.exception.BusinessException;
import org.example.app.model.dto.PostDTO;
import org.example.app.request.RequestData;
import org.example.app.request.user.AddLikeRequest;
import org.example.app.response.ResponseData;
import org.example.app.response.user.AddLikeResponse;

import static org.example.app.constant.ExceptionCode.*;

public class AddLikeAPI extends CommonAPI {
    private AddLikeAPI(){

    }
    private static AddLikeAPI INSTANCE = new AddLikeAPI();

    public static AddLikeAPI getINSTANCE() {
        return INSTANCE;
    }

    @Override
    protected ResponseData doExecute(RequestData requestData) throws Exception {
        AddLikeRequest addLikeRequest = (AddLikeRequest) requestData;
        String token = addLikeRequest.getToken();
        String postId = addLikeRequest.getPostId();
        String userId = SessionController.getInstance().getUserId(token);
        if(PostController.getINSTANCE().alreadyLike(userId, postId)){
            throw new BusinessException(REQUEST.getCode(), "user already liked this post");
        }
        PostController.getINSTANCE().addLike(userId, postId);
        PostDTO postDTO = PostController.getINSTANCE().findPostDisplayById(postId);
        return new AddLikeResponse(postDTO);
    }

    @Override
    protected RequestData parseRequestData(JsonObject jsonObject) {
        Gson gson = new Gson();
        return gson.fromJson(jsonObject, AddLikeRequest.class);
    }
}

