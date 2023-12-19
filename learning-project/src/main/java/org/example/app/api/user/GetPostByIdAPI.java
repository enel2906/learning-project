package org.example.app.api.user;

import com.google.gson.JsonObject;
import org.example.app.controller.LikedInforController;
import org.example.app.controller.PostController;
import org.example.app.controller.UserController;
import org.example.app.model.dto.PostDTO;
import org.example.app.model.dto.UserDTO;
import org.example.app.request.RequestData;
import org.example.app.request.user.GetPostByIdRequest;
import org.example.app.response.ResponseData;
import org.example.app.response.user.GetPostByIdResponse;

import java.util.List;

public class GetPostByIdAPI extends CommonAPI {
    private GetPostByIdAPI(){

    }
    private static GetPostByIdAPI INSTANCE = new GetPostByIdAPI();

    public static GetPostByIdAPI getINSTANCE() {
        return INSTANCE;
    }

    @Override
    protected ResponseData doExecute(RequestData requestData) throws Exception {
        GetPostByIdRequest getPostByIdRequest = (GetPostByIdRequest) requestData;
        String postId = getPostByIdRequest.getPostId();
        PostDTO postDTO = PostController.getINSTANCE().findPostDisplayById(postId);
        long numLike = LikedInforController.getINSTANCE().getNumLikeInfor(postId);
        List<String> userIds = LikedInforController.getINSTANCE().getUsersLiked(postId);
        List<UserDTO> userDTOs = UserController.getInstance().getListUserFromId(userIds);

        return new GetPostByIdResponse(postDTO, numLike, userDTOs);
    }

    @Override
    protected RequestData parseRequestData(JsonObject jsonObject) {
        return super.parseRequestData(jsonObject);
    }
}
