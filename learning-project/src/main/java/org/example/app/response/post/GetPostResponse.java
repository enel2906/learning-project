package org.example.app.response.post;

import org.example.app.model.dto.PostDTO;
import org.example.app.response.ResponseData;

import static org.example.app.constant.ExceptionCode.*;

import java.util.ArrayList;

public class GetPostResponse extends ResponseData {
    private ArrayList<PostDTO> listPost;

    public GetPostResponse(int code, String message, ArrayList<PostDTO> listPost) {
        super(code, message);
        this.listPost = listPost;
    }

    public ArrayList<PostDTO> getListPost() {
        return listPost;
    }

    public void setListPost(ArrayList<PostDTO> listPost) {
        this.listPost = listPost;
    }

    public GetPostResponse(ArrayList<PostDTO> listPost) {
        super(SUCCESS.getCode(), "Get post successfully");
        this.listPost = listPost;
    }
}
