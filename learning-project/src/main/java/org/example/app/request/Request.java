package org.example.app.request;

public class Request {

    private RequestData requestData;

    public Request(RequestData requestData) {
        this.requestData = requestData;
    }

    public RequestData getRequestData() {
        return requestData;
    }

    public void setRequestData(RequestData requestData) {
        this.requestData = requestData;
    }
}
