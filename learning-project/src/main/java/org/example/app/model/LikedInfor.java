package org.example.app.model;

public class LikedInfor {
    private String postId;
    private String userId;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LikedInfor(String postId, String userId) {
        this.postId = postId;
        this.userId = userId;
    }
}
