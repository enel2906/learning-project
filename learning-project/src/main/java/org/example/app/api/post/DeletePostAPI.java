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
import org.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.example.app.constant.ExceptionCode.*;

@Component
public class DeletePostAPI extends CommonAPI<DeletePostRequest, DeletePostResponse> {
    private final SessionService sessionService;
    private final PostService postService;
    private final LikedInforService likedInforService;
    private final UserService userService;

    public DeletePostAPI(SessionService sessionService, PostService postService, LikedInforService likedInforService, UserService userService){
        super(sessionService);
        this.sessionService = sessionService;
        this.postService = postService;
        this.likedInforService = likedInforService;
        this.userService = userService;
    }

    public DeletePostResponse execute(DeletePostRequest deleteRequest) {
        try{
            doExecute(deleteRequest);
            String token = deleteRequest.getToken();
            String postId = deleteRequest.getPostId();
            String userId = sessionService.getUserId(token);
            if(!postService.existPostOfUserId(postId, userId)){
                throw new BusinessException(REQUEST.getCode(), "No post id match this userId");
            }
            likedInforService.remove(postId);
            postService.remove(postId);
            return new DeletePostResponse("Deleted post "+postId);
        }catch(BusinessException e){
            return new DeletePostResponse(e.getCode(), e.getMessage());
        }catch(Exception e){
            return new DeletePostResponse(UNKNOWN.getCode(), e.getMessage());
        }
    }
}
