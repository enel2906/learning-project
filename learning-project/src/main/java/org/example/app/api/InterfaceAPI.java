package org.example.app.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.app.request.RequestData;
import org.example.app.response.ResponseData;

public interface InterfaceAPI<T , V> {
    V execute(JsonObject jsonObject);

    V doExecute(T r) throws Exception;

    T parseRequestData(JsonObject jsonObject) throws Exception;
}
