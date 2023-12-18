package org.example.app.request.user;

import org.example.app.request.RequestData;

public class DeleteRequest extends RequestData {
    private String postId;

    public DeleteRequest(String postId) {
        this.postId = postId;
    }

    public DeleteRequest(String token, String postId) {
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
