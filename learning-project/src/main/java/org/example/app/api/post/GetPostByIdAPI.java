package org.example.app.api.post;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.exception.BusinessException;
import org.example.app.model.dto.PostDTO;
import org.example.app.model.dto.UserDTO;
import org.example.app.request.post.GetPostByIdRequest;
import org.example.app.request.post.GetPostByIdRequest;
import org.example.app.response.post.GetPostByIdResponse;
import org.example.app.service.LikedInforService;
import org.example.app.service.PostService;
import org.example.app.service.SessionService;
import org.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.example.app.constant.ExceptionCode.UNKNOWN;

@Component
public class GetPostByIdAPI extends CommonAPI<GetPostByIdRequest, GetPostByIdResponse> {
    private final SessionService sessionService;
    private final PostService postService;
    private final LikedInforService likedInforService;
    private final UserService userService;

    public GetPostByIdAPI(SessionService sessionService, PostService postService, LikedInforService likedInforService, UserService userService){
        super(sessionService);
        this.sessionService = sessionService;
        this.postService = postService;
        this.likedInforService = likedInforService;
        this.userService = userService;
    }

    @Override
    public GetPostByIdResponse execute(GetPostByIdRequest getPostByIdRequest) {
        try{
            doExecute(getPostByIdRequest);
            String postId = getPostByIdRequest.getPostId();
            PostDTO postDTO = postService.findDTOByKey(postId);
            long numLike = likedInforService.getNumLikeInfor(postId);
            List<String> userIds = likedInforService.findByKey(postId);
            List<UserDTO> userDTOs = userService.getListUserFromId(userIds);
            postDTO.setNumLike(numLike);
            postDTO.setListUserLiked(userDTOs);
            return new GetPostByIdResponse(postDTO);
        }catch(BusinessException e){
            return new GetPostByIdResponse(e.getCode(), e.getMessage());
        }catch(Exception e){
            return new GetPostByIdResponse(UNKNOWN.getCode(), e.getMessage());
        }
    }
}
