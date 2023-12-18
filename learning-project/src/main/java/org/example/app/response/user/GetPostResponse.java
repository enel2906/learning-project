package org.example.app.response.user;

import org.example.app.model.dto.PostDTO;
import org.example.app.response.ResponseData;

import java.util.ArrayList;

public class GetPostResponse extends ResponseData {
    private ArrayList<PostDTO> posts;

    public ArrayList<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<PostDTO> posts) {
        this.posts = posts;
    }

    public GetPostResponse(ArrayList<PostDTO> posts) {
        this.posts = posts;
    }
}
