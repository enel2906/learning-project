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

import java.util.List;

import static org.example.app.constant.ExceptionCode.*;

public class AddLikeAPI extends CommonAPI<AddLikeRequest, AddLikeResponse> {
    private AddLikeAPI(){

    }
    private static AddLikeAPI INSTANCE = new AddLikeAPI();

    public static AddLikeAPI getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public AddLikeResponse doExecute(AddLikeRequest addLikeRequest) throws Exception {
        String token = addLikeRequest.getToken();
        String postId = addLikeRequest.getPostId();
        String userId = SessionService.getINSTANCE().getUserId(token);
        if(LikedInforService.getINSTANCE().alreadyLiked(userId, postId)){
            throw new BusinessException(REQUEST.getCode(), "user already liked this post");
        }
        LikedInforService.getINSTANCE().addNewLikeInfor(userId, postId);
        PostDTO postDTO = PostService.getINSTANCE().findDTOByKey(postId);
        long numLike = LikedInforService.getINSTANCE().getNumLikeInfor(postId);
        List<String> listUserIds = LikedInforService.getINSTANCE().findByKey(postId);
        List<UserDTO> users = UserService.getINSTANCE().getListUserFromId(listUserIds);
        return new AddLikeResponse(postDTO, numLike, users);
    }
}

