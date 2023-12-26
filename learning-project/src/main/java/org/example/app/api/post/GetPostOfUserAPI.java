package org.example.app.api.post;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.controller.LikedInforController;
import org.example.app.controller.PostController;
import org.example.app.controller.UserController;
import org.example.app.model.dto.PostDTO;
import org.example.app.model.dto.UserDTO;
import org.example.app.request.post.GetPostRequest;
import org.example.app.request.post.GetPostRequest;
import org.example.app.response.post.GetPostByIdResponse;
import org.example.app.response.post.GetPostResponse;

import java.util.ArrayList;
import java.util.List;

public class GetPostOfUserAPI extends CommonAPI<GetPostRequest, GetPostResponse> {
    private GetPostOfUserAPI(){

    }
    private static GetPostOfUserAPI INSTANCE = new GetPostOfUserAPI();

    public static GetPostOfUserAPI getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public GetPostResponse doExecute(GetPostRequest getPostsRequest) throws Exception {
        String userId = getPostsRequest.getUserId();
        ArrayList<PostDTO> postDTOs = new ArrayList<>();
        List<String> postIds = PostController.getINSTANCE().getListPostIdByUserId(userId);
        for(String postId : postIds){
            PostDTO postDTO = PostController.getINSTANCE().findPostDisplayById(postId);
            long numLike = LikedInforController.getINSTANCE().getNumLikeInfor(postId);
            List<String> userIds = LikedInforController.getINSTANCE().getUsersLiked(postId);
            List<UserDTO> userDTOs = UserController.getInstance().getListUserFromId(userIds);
            postDTO.setNumLike(numLike);
            postDTO.setListUserLiked(userDTOs);
            postDTOs.add(postDTO);
        }
        return new GetPostResponse(postDTOs);
    }


    @Override
    public GetPostRequest parseRequestData(JsonObject jsonObject) {
        Gson gson = new Gson();
        return gson.fromJson(jsonObject, GetPostRequest.class);
    }
}
