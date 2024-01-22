package org.example.app.response.user;

import org.example.app.response.ResponseData;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.example.app.constant.ExceptionCode.*;
@ResponseBody
public class UpdateAgeResponse extends ResponseData {
    private String success;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public UpdateAgeResponse(String success) {
        super(SUCCESS.getCode(), "Add age successfully!");
        this.success = success;
    }

    public UpdateAgeResponse(int code, String message){
        super(code, message);
    }
}
