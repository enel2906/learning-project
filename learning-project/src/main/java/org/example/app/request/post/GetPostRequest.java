package org.example.app.request.post;

import org.example.app.request.RequestData;

public class GetPostRequest extends RequestData {
    private String userId;
    private int page;
    private int limit;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public GetPostRequest(String userId, int page, int limit) {
        this.userId = userId;
        this.page = page;
        this.limit = limit;
    }

    public GetPostRequest(String token, String userId, int page, int limit) {
        super(token);
        this.userId = userId;
        this.page = page;
        this.limit = limit;
    }

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
