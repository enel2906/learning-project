package org.example.app.api.post;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.controller.LikedInforController;
import org.example.app.controller.PostController;
import org.example.app.controller.UserController;
import org.example.app.model.dto.PostDTO;
import org.example.app.model.dto.UserDTO;
import org.example.app.request.post.GetPostByIdRequest;
import org.example.app.request.post.GetPostByIdRequest;
import org.example.app.response.post.GetPostByIdResponse;

import java.util.List;

public class GetPostByIdAPI extends CommonAPI<GetPostByIdRequest, GetPostByIdResponse> {
    private GetPostByIdAPI(){

    }
    private static GetPostByIdAPI INSTANCE = new GetPostByIdAPI();

    public static GetPostByIdAPI getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public GetPostByIdResponse doExecute(GetPostByIdRequest getPostByIdRequest) throws Exception {
        String postId = getPostByIdRequest.getPostId();
        PostDTO postDTO = PostController.getINSTANCE().findPostDisplayById(postId);
        long numLike = LikedInforController.getINSTANCE().getNumLikeInfor(postId);
        List<String> userIds = LikedInforController.getINSTANCE().getUsersLiked(postId);
        List<UserDTO> userDTOs = UserController.getInstance().getListUserFromId(userIds);

        postDTO.setNumLike(numLike);
        postDTO.setListUserLiked(userDTOs);

        return new GetPostByIdResponse(postDTO);
    }

    @Override
    public GetPostByIdRequest parseRequestData(JsonObject jsonObject) throws Exception {
        return new Gson().fromJson(jsonObject, GetPostByIdRequest.class);
    }
}
