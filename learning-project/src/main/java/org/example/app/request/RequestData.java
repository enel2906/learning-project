package org.example.app.request;

public class RequestData {
    public RequestData(){

    }
    public RequestData(String token) {
        this.token = token;
    }

    protected String token;
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    public void checkValidation(){}

    public boolean needCheckToken(){
        return true;
    };

}
