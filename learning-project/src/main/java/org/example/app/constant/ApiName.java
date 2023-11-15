package org.example.app.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiName {
    public static final String NAME_KEY = "api-name";
    public static final String TOKEN_KEY = "token";
    public static final String GETINFOR_API_NAME = "information";
    public static final String LOGIN_API_NAME = "log-in";
    public static final String LOGOUT_API_NAME = "logout";
    public static final String SIGNIN_API_NAME = "sign-in";
    public static final String UPDATE_AGE_NAME = "update-age";

    public static final List<String> UNAUTHEN_API = Arrays.asList(LOGIN_API_NAME,
                                                                  SIGNIN_API_NAME);


    public static String AGE_CHANGE = "age-change";
}
