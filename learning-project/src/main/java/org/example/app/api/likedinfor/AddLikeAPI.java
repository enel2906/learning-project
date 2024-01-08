package org.example.app.api.likedinfor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.exception.BusinessException;
import org.example.app.model.dto.PostDTO;
import org.example.app.model.dto.UserDTO;
import org.example.app.request.likeinfor.AddLikeRequest;
import org.example.app.response.likeinfor.AddLikeResponse;
import org.example.app.service.LikedInforService;
import org.example.app.service.PostService;
import org.example.app.service.SessionService;
import org.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.example.app.constant.ExceptionCode.*;

@Component
public class AddLikeAPI extends CommonAPI<AddLikeRequest, AddLikeResponse> {
    private final SessionService sessionService;
    private final PostService postService;
    private final LikedInforService likedInforService;
    private final UserService userService;

    public AddLikeAPI(SessionService sessionService, PostService postService, LikedInforService likedInforService, UserService userService){
        super(sessionService);
        this.sessionService = sessionService;
        this.postService = postService;
        this.likedInforService = likedInforService;
        this.userService = userService;
    }

    @Override
    public AddLikeResponse doExecute(AddLikeRequest addLikeRequest) throws Exception {
        String token = addLikeRequest.getToken();
        String postId = addLikeRequest.getPostId();
        String userId = sessionService.getUserId(token);
        if(likedInforService.alreadyLiked(userId, postId)){
            throw new BusinessException(REQUEST.getCode(), "user already liked this post");
        }
        likedInforService.addNewLikeInfor(userId, postId);
        PostDTO postDTO = postService.findDTOByKey(postId);
        long numLike = likedInforService.getNumLikeInfor(postId);
        List<String> listUserIds = likedInforService.findByKey(postId);
        List<UserDTO> users = userService.getListUserFromId(listUserIds);
        return new AddLikeResponse(postDTO, numLike, users);
    }
}

