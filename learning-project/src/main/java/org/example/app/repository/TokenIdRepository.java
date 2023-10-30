package org.example.app.repository;

import org.example.app.model.Token;
import org.example.app.model.User;
import org.example.app.util.Util;

import java.util.HashMap;
import java.util.Map;

public class TokenIdRepository {
    private static Map<String, Map<String, Object>> tokenIdMap = new HashMap<>();
    private static String TOKEN_ID = "token_id";
    private static String USER_ID = "user_id";

    private static String TIME = "time";

    public static String getTokenId() {
        return TOKEN_ID;
    }

    public static String getUserId() {
        return USER_ID;
    }

    public static String getTIME() {
        return TIME;
    }

    public static String createToken(String id){
        Token token = new Token(id);
        Map<String, Object> subMap = new HashMap<>();
        String tokenId = token.getTokenId();
        String userId = token.getUserId();
        Long time = token.getTime();

        subMap.put(TIME, time);
        subMap.put(TOKEN_ID, tokenId);
        subMap.put(USER_ID, userId);
        tokenIdMap.put(tokenId, subMap);

        return tokenId;
    }

    public static Map<String, Map<String, Object>> getTokenIdMap(){
        return tokenIdMap;
    }

    public static int getTime(String tokenId){
        return (int) tokenIdMap.get(tokenId).get(TIME);
    }

    public static void removeToken(String tokenId){
        tokenIdMap.remove(tokenId);
    }

    public static Token convertFromTokenMapToTokenModel(Map<String, String> tokenMap){
        String tokenId = tokenMap.get(TOKEN_ID);
        String userId = tokenMap.get(USER_ID);

        return new Token(tokenId,userId);
    }

    public static Map<String, String> convertFromTokenModelToTokenIdMap(Token token){
        String tokenId = token.getTokenId();
        String userId = token.getUserId();

        Map<String, String> result = new HashMap<>();
        result.put(TOKEN_ID, tokenId);
        result.put(USER_ID, userId);

        return result;
    }

    public static boolean isValidToken(String token) {
        for (Map.Entry<String, Map<String, Object>> keyValue : tokenIdMap.entrySet()) {
            if(keyValue.getKey().equals(token)){
                return true;
            }
        }

        return false;

    }

    public static String getUserId(String token){
        return (String) tokenIdMap.get(token).get(USER_ID);
    }

    public static void checkValidTime(int timeLimit){
        for(Map.Entry<String, Map<String, Object>> keyValue : tokenIdMap.entrySet()){
            int time = (int) keyValue.getValue().get(TIME);
            String token = keyValue.getKey();
            if(time >= timeLimit){
                removeToken(token);
            }
        }
    }
}
