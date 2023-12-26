package org.example.app.request.post;

import org.example.app.request.RequestData;

public class DeletePostRequest extends RequestData {
    private String postId;

    public DeletePostRequest(String postId) {
        this.postId = postId;
    }

    public DeletePostRequest(String token, String postId) {
        super(token);
        this.postId = postId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
