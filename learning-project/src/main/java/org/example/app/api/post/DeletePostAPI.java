package org.example.app.api.post;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.controller.LikedInforController;
import org.example.app.controller.PostController;
import org.example.app.controller.SessionController;
import org.example.app.exception.BusinessException;
import org.example.app.request.post.DeletePostRequest;
import org.example.app.request.post.DeletePostRequest;
import org.example.app.response.post.DeletePostResponse;

import static org.example.app.constant.ExceptionCode.*;
public class DeletePostAPI extends CommonAPI<DeletePostRequest, DeletePostResponse> {
    private DeletePostAPI(){

    }
    private static DeletePostAPI INSTANCE = new DeletePostAPI();

    public static DeletePostAPI getINSTANCE() {
        return INSTANCE;
    }

    public DeletePostResponse doExecute(DeletePostRequest deleteRequest) throws Exception {
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
    public DeletePostRequest parseRequestData(JsonObject jsonObject) {
        Gson gson = new Gson();
        return gson.fromJson(jsonObject, DeletePostRequest.class);
    }
}
