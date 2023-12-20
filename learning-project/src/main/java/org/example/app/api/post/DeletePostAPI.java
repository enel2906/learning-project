package org.example.app.api.post.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.controller.LikedInforController;
import org.example.app.controller.PostController;
import org.example.app.controller.SessionController;
import org.example.app.exception.BusinessException;
import org.example.app.request.RequestData;
import org.example.app.request.user.DeletePostRequest;
import org.example.app.response.ResponseData;
import org.example.app.response.user.DeletePostResponse;

import static org.example.app.constant.ExceptionCode.*;
public class DeletePostAPI extends CommonAPI {
    private DeletePostAPI(){

    }
    private static DeletePostAPI INSTANCE = new DeletePostAPI();

    public static DeletePostAPI getINSTANCE() {
        return INSTANCE;
    }

    public ResponseData doExecute(RequestData requestData) throws Exception {
        DeletePostRequest deleteRequest = (DeletePostRequest) requestData;

        String token = deleteRequest.getToken();
        String postId = deleteRequest.getPostId();
        String userId = SessionController.getInstance().getUserId(token);
        if(!PostController.getINSTANCE().isExistPostOfUserId(postId, userId)){
            throw new BusinessException(REQUEST.getCode(), "No post id match this userId");
        }
        LikedInforController.getINSTANCE().deletePost(postId);
        PostController.getINSTANCE().deletePost(postId);
        return new DeletePostResponse("Deleted post "+postId);
    }

    @Override
    protected RequestData parseRequestData(JsonObject jsonObject) {
        Gson gson = new Gson();
        return gson.fromJson(jsonObject, DeletePostRequest.class);
    }
}
