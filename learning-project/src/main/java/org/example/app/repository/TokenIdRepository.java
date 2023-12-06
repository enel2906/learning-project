package org.example.app.repository;

import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;
import org.example.app.configuration.databaseconfig.MongoConfig;
import org.example.app.model.Token;
import org.example.app.model.User;
import org.example.app.util.Util;

import javax.print.Doc;
import org.bson.Document;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class TokenIdRepository {
    private static String TOKEN_ID = "token_id";
    private static String USER_ID = "user_id";

    private static String TIME = "time";
    private static String COLLECTION_NAME = "tokenIds";
    private static MongoCollection<Document> tokenIdCollection = MongoConfig.getDataBaseCollection(COLLECTION_NAME);

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
        long time = Util.convertTimeToSecond(LocalTime.now());
        Document filter = new Document(USER_ID, id).append(TIME, time);
        tokenIdCollection.insertOne(filter);
        String token =  filter.get("_id").toString();
        return token;
    }


    public static long getTime(String tokenId){
        Document filter = new Document("_id", new ObjectId(tokenId));
        return (long) tokenIdCollection.find(filter).limit(1).first().get(TIME);
    }

    public static void removeToken(String tokenId){
        Document filter = new Document("_id", new ObjectId(tokenId));
        tokenIdCollection.deleteOne(filter);
    }

    public static Token convertFromDocumentToTokenModel(Document tokenDoc) throws Exception{
        String tokenId = tokenDoc.get(TOKEN_ID).toString();
        String userId = tokenDoc.get(USER_ID).toString();

        return new Token(tokenId,userId);
    }
    public static boolean isValidToken(String token) throws Exception{
        Document filter = new Document("_id", new ObjectId(token));
        return tokenIdCollection.find(filter).first() != null;
    }

    public static String getUserId(String token){
        Document filter = new Document("_id", new ObjectId(token));
        return (String) tokenIdCollection.find(filter).limit(1).first().get(USER_ID);
    }
}
