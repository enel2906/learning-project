package org.example.app.api.post;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.exception.BusinessException;
import org.example.app.model.dto.PostDTO;
import org.example.app.model.dto.UserDTO;
import org.example.app.request.post.GetPostRequest;
import org.example.app.request.post.GetPostRequest;
import org.example.app.response.post.GetPostByIdResponse;
import org.example.app.response.post.GetPostResponse;
import org.example.app.service.LikedInforService;
import org.example.app.service.PostService;
import org.example.app.service.SessionService;
import org.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.example.app.constant.ExceptionCode.UNKNOWN;

@Component
public class GetPostOfUserAPI extends CommonAPI<GetPostRequest, GetPostResponse> {
    private final SessionService sessionService;
    private final PostService postService;
    private final LikedInforService likedInforService;
    private final UserService userService;

    public GetPostOfUserAPI(SessionService sessionService, PostService postService, LikedInforService likedInforService, UserService userService){
        super(sessionService);
        this.sessionService = sessionService;
        this.postService = postService;
        this.likedInforService = likedInforService;
        this.userService = userService;
    }

    @Override
    public GetPostResponse execute(GetPostRequest getPostsRequest) {
        try{
            doExecute(getPostsRequest);
            String userId = getPostsRequest.getUserId();
            int page = getPostsRequest.getPage();
            int limit = getPostsRequest.getLimit();
            int skip = (page-1) * limit;
            ArrayList<PostDTO> postDTOs = new ArrayList<>();
            List<String> postIds = postService.getListPostIdWithPage(userId, skip, limit);
            for(String postId : postIds){
                PostDTO postDTO = postService.findDTOByKey(postId);
                long numLike = likedInforService.getNumLikeInfor(postId);
                List<String> userIds = likedInforService.findByKey(postId);
                List<UserDTO> userDTOs = userService.getListUserFromId(userIds);
                postDTO.setNumLike(numLike);
                postDTO.setListUserLiked(userDTOs);
                postDTOs.add(postDTO);
            }
            return new GetPostResponse(postDTOs);
        }catch(BusinessException e){
            return new GetPostResponse(e.getCode(), e.getMessage());
        }catch(Exception e){
            return new GetPostResponse(UNKNOWN.getCode(), e.getMessage());
        }
    }

}
