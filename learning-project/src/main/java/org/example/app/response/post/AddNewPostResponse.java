package org.example.app.response.post;

import org.example.app.response.ResponseData;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
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
