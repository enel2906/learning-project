package org.example.app.repository;

import org.example.app.util.Util;

import java.util.HashMap;
import java.util.Map;

public class TokenIdRepository {
    private static Map<String, String> tokenIdMap = new HashMap<>();

    public static String addTokenId(String id){
            String token = Util.getRandomString();
            tokenIdMap.put(token, id);

            return token;
    }
    
    public static void removeToken(String token){
        tokenIdMap.remove(token);
    }

    public static String getId(String token){
        return tokenIdMap.get(token);
    }
}
