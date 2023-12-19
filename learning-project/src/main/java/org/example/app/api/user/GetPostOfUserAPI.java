package org.example.app.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.controller.LikedInforController;
import org.example.app.controller.PostController;
import org.example.app.controller.UserController;
import org.example.app.model.LikedInfor;
import org.example.app.model.dto.PostDTO;
import org.example.app.model.dto.UserDTO;
import org.example.app.request.RequestData;
import org.example.app.request.user.GetPostRequest;
import org.example.app.response.ResponseData;
import org.example.app.response.user.GetPostByIdResponse;
import org.example.app.response.user.GetPostResponse;

import java.util.ArrayList;
import java.util.List;

public class GetPostOfUserAPI extends CommonAPI{
    private GetPostOfUserAPI(){

    }
    private static GetPostOfUserAPI INSTANCE = new GetPostOfUserAPI();

    public static GetPostOfUserAPI getINSTANCE() {
        return INSTANCE;
    }

    @Override
    protected ResponseData doExecute(RequestData requestData) throws Exception {
        GetPostRequest getPostsRequest = (GetPostRequest) requestData;
        String userId = getPostsRequest.getUserId();
        ArrayList<GetPostByIdResponse> result = new ArrayList<>();
        List<String> postIds = PostController.getINSTANCE().getListPostIdByUserId(userId);
        for(String postId : postIds){
            PostDTO postDTO = PostController.getINSTANCE().findPostDisplayById(postId);
            long numLike = LikedInforController.getINSTANCE().getNumLikeInfor(postId);
            List<String> userIds = LikedInforController.getINSTANCE().getUsersLiked(postId);
            List<UserDTO> userDTOs = UserController.getInstance().getListUserFromId(userIds);

            result.add(new GetPostByIdResponse(postDTO, numLike, userDTOs));
        }
        return new GetPostResponse(result);
    }


    @Override
    protected RequestData parseRequestData(JsonObject jsonObject) {
        Gson gson = new Gson();
        return gson.fromJson(jsonObject, GetPostRequest.class);
    }
}
