package org.example.app.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.request.RequestData;
import org.example.app.response.ResponseData;

public interface InterfaceAPI<T>{
    ResponseData execute(T requestData);

}
