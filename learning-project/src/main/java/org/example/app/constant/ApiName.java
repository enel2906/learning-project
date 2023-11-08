package org.example.app.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiName {
    public static final String GETINFOR_API_NAME = "getinfor_api";
    public static final String LOGIN_API_NAME = "login_api";
    public static final String LOGOUT_API_NAME = "logout_api";
    public static final String SIGNIN_API_NAME = "signin_api";
    public static final List<String> UNAUTHEN_API = Arrays.asList(LOGIN_API_NAME,
                                                                  SIGNIN_API_NAME);



}
