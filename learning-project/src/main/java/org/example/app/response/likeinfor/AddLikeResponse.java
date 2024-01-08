package org.example.app.response.likeinfor;

import org.example.app.model.dto.PostDTO;
import org.example.app.model.dto.UserDTO;
import org.example.app.response.ResponseData;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.example.app.constant.ExceptionCode.*;

import java.util.List;

@ResponseBody
public class AddLikeResponse extends ResponseData {
    private PostDTO post;
    private long numLike;
    private List<UserDTO> listUserLiked;

    public AddLikeResponse(PostDTO post, long numLike, List<UserDTO> listUserLiked) {
        super(SUCCESS.getCode(), "Add like successfully!");
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
