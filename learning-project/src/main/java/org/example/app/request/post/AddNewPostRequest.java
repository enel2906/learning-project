package org.example.app.request.post;

import org.example.app.request.RequestData;

public class AddNewPostRequest extends RequestData {
    private String content;
    private String type;

    public AddNewPostRequest(String content, String type) {
        this.content = content;
        this.type = type;
    }

    public AddNewPostRequest(String token, String content, String type) {
        super(token);
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
