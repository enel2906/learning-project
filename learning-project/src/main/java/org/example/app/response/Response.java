package org.example.app.response;

public class Response {

    private int code ;

    private String message;
    private ResponseData responseData;
    public Response() {
    }

    public Response(int code, String message, ResponseData responseData) {
        this.code = code;
        this.message = message;
        this.responseData = responseData;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseData getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

    public String toString(){
        return "code: "+code+"  message: "+message+"  reponseData: "+responseData;
    }
}
