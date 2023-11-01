package org.example.app.response.user;

public class LogoutResponse {
    private int code;
    private String message;
    public LogoutResponse(){
    }
    public LogoutResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
