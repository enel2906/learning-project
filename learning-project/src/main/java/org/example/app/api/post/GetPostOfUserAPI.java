package org.example.app.api.post;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.api.CommonAPI;
import org.example.app.model.dto.PostDTO;
import org.example.app.model.dto.UserDTO;
import org.example.app.request.post.GetPostRequest;
import org.example.app.request.post.GetPostRequest;
import org.example.app.response.post.GetPostByIdResponse;
import org.example.app.response.post.GetPostResponse;
import org.example.app.service.LikedInforService;
import org.example.app.service.PostService;
import org.example.app.service.UserService;

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
        List<String> postIds = PostService.getINSTANCE().getListPostIdByUserId(userId);
        for(String postId : postIds){
            PostDTO postDTO = PostService.getINSTANCE().findDTOByKey(postId);
            long numLike = LikedInforService.getINSTANCE().getNumLikeInfor(postId);
            List<String> userIds = LikedInforService.getINSTANCE().findByKey(postId);
            List<UserDTO> userDTOs = UserService.getINSTANCE().getListUserFromId(userIds);
            postDTO.setNumLike(numLike);
            postDTO.setListUserLiked(userDTOs);
            postDTOs.add(postDTO);
        }
        return new GetPostResponse(postDTOs);
    }

}
