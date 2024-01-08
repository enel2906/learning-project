package org.example.app.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;

@Document(collection = "likedinfors")
public class LikedInfor {
    @Id
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
