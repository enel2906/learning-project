package org.example.app.response.user;

import org.example.app.response.ResponseData;

public class UpdateAgeResponse extends ResponseData {
    private String success;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public UpdateAgeResponse(String success) {
        this.success = success;
    }
}
