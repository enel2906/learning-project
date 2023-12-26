package org.example.app.response.post;

import org.example.app.model.dto.PostDTO;
import org.example.app.model.dto.UserDTO;
import org.example.app.response.ResponseData;

import java.util.List;

public class GetPostByIdResponse extends ResponseData {
    private PostDTO post;

    public GetPostByIdResponse(PostDTO post) {
        this.post = post;
    }

    public PostDTO getPost() {
        return post;
    }

    public void setPost(PostDTO post) {
        this.post = post;
    }
}
