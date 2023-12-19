package org.example.app.response.user;

import org.example.app.model.dto.PostDTO;
import org.example.app.model.dto.UserDTO;
import org.example.app.response.ResponseData;

import java.util.List;

public class GetPostByIdResponse extends ResponseData {
    private PostDTO post;
    private long numLike;
    private List<UserDTO> listUserLiked;

    public GetPostByIdResponse(PostDTO post, long numLike, List<UserDTO> listUserLiked) {
        this.post = post;
        this.numLike = numLike;
        this.listUserLiked = listUserLiked;
    }

    public PostDTO getPost() {
        return post;
    }

    public void setPost(PostDTO post) {
        this.post = post;
    }

    public long getNumLike() {
        return numLike;
    }

    public void setNumLike(long numLike) {
        this.numLike = numLike;
    }

    public List<UserDTO> getListUserLiked() {
        return listUserLiked;
    }

    public void setListUserLiked(List<UserDTO> listUserLiked) {
        this.listUserLiked = listUserLiked;
    }
}
