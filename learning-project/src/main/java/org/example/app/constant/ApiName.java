package org.example.app.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ApiName {
    NAME_KEY("apiName"),
    GETINFOR_API_NAME("information"),
    LOGIN_API_NAME("log-in"),
    LOGOUT_API_NAME("logout"),
    SIGNIN_API_NAME("sign-in"),
    UPDATE_AGE_NAME("update-age"),
    ADD_NEW_POST("add-post"),
    DELETE_POST("delete-post"),
    GET_POST("get-post"),
    GET_USER_INFOR("get-user-infor"),
    ADD_LIKE("like");

    public static final List<ApiName> UNAUTHEN_API = Arrays.asList(LOGIN_API_NAME,
                                                                  SIGNIN_API_NAME);
    public final String name;


    ApiName(String name) {
        this.name = name;
    }

    public static ApiName fromString(String name) {
        for (ApiName apiName : values()) {
            if (apiName.name.equals(name)) {
                return apiName;
            }
        }
        return null;
    }

}
