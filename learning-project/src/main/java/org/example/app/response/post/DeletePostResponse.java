package org.example.app.response.post;

import org.example.app.response.ResponseData;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
public class DeletePostResponse extends ResponseData {
    private String message;

    public DeletePostResponse(String message) {
        this.message = message;
    }
    public DeletePostResponse(int code, String message){
        super(code, message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
