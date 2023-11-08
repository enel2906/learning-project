package org.example.app.request;



public class RequestData {

    private String apiName;
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

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }
}
