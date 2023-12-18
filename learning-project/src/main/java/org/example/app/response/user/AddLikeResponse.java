package org.example.app.response.user;

import org.example.app.model.dto.PostDTO;
import org.example.app.response.ResponseData;

public class AddLikeResponse extends ResponseData {
    private PostDTO postDTO;

    public PostDTO getPostDTO() {
        return postDTO;
    }

    public void setPostDTO(PostDTO postDTO) {
        this.postDTO = postDTO;
    }

    public AddLikeResponse(PostDTO postDTO) {
        this.postDTO = postDTO;
    }
}
