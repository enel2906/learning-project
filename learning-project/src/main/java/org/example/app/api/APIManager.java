package org.example.app.api;

import org.example.app.api.CommonAPI;
import org.example.app.api.likedinfor.AddLikeAPI;
import org.example.app.api.post.user.AddNewPostAPI;
import org.example.app.api.post.user.DeletePostAPI;
import org.example.app.api.post.user.GetPostByIdAPI;
import org.example.app.api.post.user.GetPostOfUserAPI;
import org.example.app.api.user.*;
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
                case GET_POST -> GetPostOfUserAPI.getINSTANCE();
                case GET_USER_INFOR -> GetUserInforAPI.getInstance();
                case ADD_LIKE -> AddLikeAPI.getINSTANCE();
                case GET_POST_BY_ID -> GetPostByIdAPI.getINSTANCE();
                default -> null;
            };
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid API name: " + apiName);
            return null;
        }
    }
}

