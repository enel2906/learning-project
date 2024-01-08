package org.example.app.response.post;

import org.example.app.model.dto.PostDTO;
import org.example.app.model.dto.UserDTO;
import org.example.app.response.ResponseData;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ResponseBody
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
