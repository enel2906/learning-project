package org.example.app.response.post;


import org.example.app.response.ResponseData;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class AddNewPostResponse extends ResponseData {
    private String notification;

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public AddNewPostResponse(String notification) {
        this.notification = notification;
    }
    public AddNewPostResponse(int code, String message){
        super(code, message);
    }
}
