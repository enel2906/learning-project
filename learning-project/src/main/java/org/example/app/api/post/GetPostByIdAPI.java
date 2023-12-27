package org.example.app.api.post;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.model.dto.PostDTO;
import org.example.app.model.dto.UserDTO;
import org.example.app.request.post.GetPostByIdRequest;
import org.example.app.request.post.GetPostByIdRequest;
import org.example.app.response.post.GetPostByIdResponse;
import org.example.app.service.LikedInforService;
import org.example.app.service.PostService;
import org.example.app.service.UserService;

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
        PostDTO postDTO = PostService.getINSTANCE().findDTOByKey(postId);
        long numLike = LikedInforService.getINSTANCE().getNumLikeInfor(postId);
        List<String> userIds = LikedInforService.getINSTANCE().findByKey(postId);
        List<UserDTO> userDTOs = UserService.getINSTANCE().getListUserFromId(userIds);

        postDTO.setNumLike(numLike);
        postDTO.setListUserLiked(userDTOs);

        return new GetPostByIdResponse(postDTO);
    }
}
