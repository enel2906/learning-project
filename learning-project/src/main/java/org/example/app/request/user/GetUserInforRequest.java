package org.example.app.request.user;

import org.example.app.request.RequestData;

public class GetUserInforRequest extends RequestData {
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public GetUserInforRequest(String userId) {
        this.userId = userId;
    }

    public GetUserInforRequest(String token, String userId) {
        super(token);
        this.userId = userId;
    }
}
