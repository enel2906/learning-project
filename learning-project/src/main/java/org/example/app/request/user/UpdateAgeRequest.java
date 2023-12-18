package org.example.app.request.user;

import org.example.app.request.RequestData;

import static org.example.app.constant.ApiName.UPDATE_AGE_NAME;

public class UpdateAgeRequest extends RequestData {
    private int ageChange;

    public int getAgeChange() {
        return ageChange;
    }

    public void setAgeChange(int ageChange) {
        this.ageChange = ageChange;
    }

    public UpdateAgeRequest(String token, int ageChange){
        super(token);
        this.ageChange = ageChange;
    }
}
