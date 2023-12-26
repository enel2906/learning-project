package org.example.app.request.user;

import org.example.app.request.RequestData;

public class LogoutRequest extends RequestData {
    public LogoutRequest(String token){
        super(token);
    }

}
