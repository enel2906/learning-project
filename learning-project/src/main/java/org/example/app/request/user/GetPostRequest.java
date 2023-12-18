package org.example.app.request.user;

import org.example.app.request.RequestData;

public class GetPostRequest extends RequestData {
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public GetPostRequest() {
    }

    public GetPostRequest(String token) {
        super(token);
    }

    public GetPostRequest(String token, String userId) {
        super(token);
        this.userId = userId;
    }
}
