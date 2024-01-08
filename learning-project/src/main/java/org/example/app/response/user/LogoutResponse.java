package org.example.app.response.user;

import org.example.app.response.ResponseData;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.example.app.constant.ExceptionCode.*;
@ResponseBody
public class LogoutResponse extends ResponseData {

    public LogoutResponse(){
        super(SUCCESS.getCode(), "Logout successfully");
    }
    public LogoutResponse(int code, String message) {
        super(code, message);

    }

    public String toString(){
        return "Logout successfully";
    }
}
