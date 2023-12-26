package org.example.app.request.likeinfor;

import org.example.app.request.RequestData;

public class AddLikeRequest extends RequestData {
    private String postId;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public AddLikeRequest(String postId) {
        this.postId = postId;
    }

    public AddLikeRequest(String token, String postId) {
        super(token);
        this.postId = postId;
    }
}
