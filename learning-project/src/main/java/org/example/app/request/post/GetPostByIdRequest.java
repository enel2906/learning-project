package org.example.app.request.post;

import org.example.app.request.RequestData;

public class GetPostByIdRequest extends RequestData {
    private String postId;

    public GetPostByIdRequest(String postId) {
        this.postId = postId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public GetPostByIdRequest(String token, String postId) {
        super(token);
        this.postId = postId;
    }
}
