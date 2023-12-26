package org.example.app.response.post;

import org.example.app.response.ResponseData;

public class DeletePostResponse extends ResponseData {
    private String message;

    public DeletePostResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
