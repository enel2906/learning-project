package org.example.app.api.user;

import com.google.gson.JsonObject;
import org.example.app.constant.ApiName;
import org.example.app.request.Request;
import org.example.app.request.RequestData;
import org.example.app.request.user.InforRequest;
import org.example.app.request.user.LogoutRequest;
import org.example.app.request.user.UpdateAgeRequest;
import org.example.app.response.Response;

import org.example.app.constant.ApiName;



public class APIManager {
    public static CommonAPI getAPI(String apiName) {
        try {
            ApiName enumValue = ApiName.fromString(apiName);
            return switch (enumValue) {
                case GETINFOR_API_NAME -> GetInforAPI.getInstance();
                case LOGOUT_API_NAME -> LogoutAPI.getInstance();
                case UPDATE_AGE_NAME -> UpdateAgeAPI.getINSTANCE();
                case LOGIN_API_NAME -> LoginAPI.getInstance();
                case SIGNIN_API_NAME -> SigninAPI.getINSTANCE();
                case ADD_NEW_POST -> AddNewPostAPI.getINSTANCE();
                case DELETE_POST -> DeletePostAPI.getINSTANCE();
                case GET_POST -> GetPostsAPI.getINSTANCE();
                case GET_USER_INFOR -> GetUserInforAPI.getInstance();
                case ADD_LIKE -> AddLikeAPI.getINSTANCE();
                default -> null;
            };
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid API name: " + apiName);
            return null;
        }
    }
}

