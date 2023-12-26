package org.example.app.response.post;

import org.example.app.response.ResponseData;

public class AddNewPostResponse extends ResponseData {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AddNewPostResponse(String message) {
        this.message = message;
    }
}
