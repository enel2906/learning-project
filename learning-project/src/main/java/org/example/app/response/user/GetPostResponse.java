package org.example.app.response.user;

import org.example.app.model.dto.PostDTO;
import org.example.app.response.ResponseData;

import java.util.ArrayList;

public class GetPostResponse extends ResponseData {
    private ArrayList<GetPostByIdResponse> listPost;

    public ArrayList<GetPostByIdResponse> getListPost() {
        return listPost;
    }

    public void setListPost(ArrayList<GetPostByIdResponse> listPost) {
        this.listPost = listPost;
    }

    public GetPostResponse(ArrayList<GetPostByIdResponse> listPost) {
        this.listPost = listPost;
    }
}
