package org.example.app.api.likedinfor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.controller.LikedInforController;
import org.example.app.controller.PostController;
import org.example.app.controller.SessionController;
import org.example.app.controller.UserController;
import org.example.app.exception.BusinessException;
import org.example.app.model.dto.PostDTO;
import org.example.app.model.dto.UserDTO;
import org.example.app.request.likeinfor.AddLikeRequest;
import org.example.app.response.likeinfor.AddLikeResponse;

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
        String userId = SessionController.getInstance().getUserId(token);
        if(LikedInforController.getINSTANCE().alreadyLiked(userId, postId)){
            throw new BusinessException(REQUEST.getCode(), "user already liked this post");
        }
        LikedInforController.getINSTANCE().addNewLikeInfor(userId, postId);
        PostDTO postDTO = PostController.getINSTANCE().findPostDisplayById(postId);
        long numLike = LikedInforController.getINSTANCE().getNumLikeInfor(postId);
        List<String> listUserIds = LikedInforController.getINSTANCE().getUsersLiked(postId);
        List<UserDTO> users = UserController.getInstance().getListUserFromId(listUserIds);
        return new AddLikeResponse(postDTO, numLike, users);
    }

    @Override
    public AddLikeRequest parseRequestData(JsonObject jsonObject) {
        Gson gson = new Gson();
        return gson.fromJson(jsonObject, AddLikeRequest.class);
    }
}

