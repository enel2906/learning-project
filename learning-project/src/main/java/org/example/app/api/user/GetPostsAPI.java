package org.example.app.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.controller.PostController;
import org.example.app.controller.SessionController;
import org.example.app.model.dto.PostDTO;
import org.example.app.request.RequestData;
import org.example.app.request.user.GetPostRequest;
import org.example.app.response.ResponseData;
import org.example.app.response.user.GetPostResponse;

import java.util.ArrayList;

public class GetPostsAPI extends CommonAPI{
    private GetPostsAPI(){

    }
    private static GetPostsAPI INSTANCE = new GetPostsAPI();

    public static GetPostsAPI getINSTANCE() {
        return INSTANCE;
    }

    @Override
    protected ResponseData doExecute(RequestData requestData) throws Exception {
        GetPostRequest getPostsRequest = (GetPostRequest) requestData;
        String userId = getPostsRequest.getUserId();
        ArrayList<PostDTO> listPost = PostController.getINSTANCE().getAllPostById(userId);

        return new GetPostResponse(listPost);
    }

    @Override
    protected RequestData parseRequestData(JsonObject jsonObject) {
        Gson gson = new Gson();
        return gson.fromJson(jsonObject, GetPostRequest.class);
    }
}
