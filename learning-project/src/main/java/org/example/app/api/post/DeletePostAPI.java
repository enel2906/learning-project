package org.example.app.api.post;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.exception.BusinessException;
import org.example.app.request.post.DeletePostRequest;
import org.example.app.request.post.DeletePostRequest;
import org.example.app.response.post.DeletePostResponse;
import org.example.app.service.LikedInforService;
import org.example.app.service.PostService;
import org.example.app.service.SessionService;

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
        String userId = SessionService.getINSTANCE().getUserId(token);
        if(!PostService.getINSTANCE().existPostOfUserId(postId, userId)){
            throw new BusinessException(REQUEST.getCode(), "No post id match this userId");
        }
        LikedInforService.getINSTANCE().remove(postId);
        PostService.getINSTANCE().remove(postId);
        return new DeletePostResponse("Deleted post "+postId);
    }
}
