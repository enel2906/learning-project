package org.example.app.repository;

import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;
import org.example.app.configuration.databaseconfig.MongoConfig;
import org.example.app.model.Token;

import org.bson.Document;
import org.example.app.util.Util;

import java.time.LocalDateTime;

public class SessionRepository {
    private static final String SESSION_ID = "_id";
    private static final String TOKEN = "token";
    private static final String USER_ID = "user_id";
    private static final String IP_LOGIN = "ipLogin";
    private static final String TIME = "time_login";
    private static final String DATABASE_NAME = "company";
    private static final String COLLECTION_NAME ="sessions";
    private static final String RECENT_ACTIVITY = "recent_active";
    private static final String ROLE = "role";
    private static final MongoCollection<Document> tokenIdCollection = MongoConfig.getSessionsCollection(DATABASE_NAME, COLLECTION_NAME);

    public static String createToken(String id, String ipLogin, int role) throws Exception{
        Document idFilter = new Document(USER_ID, id).append(IP_LOGIN,ipLogin);
        tokenIdCollection.deleteOne(idFilter);
        String token = Util.getRandomString();
        LocalDateTime time = LocalDateTime.now();
        Document filter = new Document(TOKEN, token)
                                        .append(USER_ID, id)
                                        .append(ROLE, role)
                                        .append(TIME, time).append(IP_LOGIN, ipLogin)
                                        .append(RECENT_ACTIVITY, time);
        tokenIdCollection.insertOne(filter);
        return token;
    }

    public static int countIpLogin(String id) throws Exception{
        Document idFilter = new Document(USER_ID, id);
        return (int) tokenIdCollection.countDocuments(idFilter);
    }

    public static long getTime(String tokenId) throws Exception {
        Document filter = new Document("_id", new ObjectId(tokenId));
        return (long) tokenIdCollection.find(filter).limit(1).first().get(TIME);
    }

    public static int getRoleByToken(String token) throws Exception{
        Document condition = new Document(TOKEN, token);
        return (int) tokenIdCollection.find(condition).limit(1).first().get(ROLE);
    }

    public static void removeToken(String tokenId) {
        Document filter = new Document(TOKEN, tokenId);
        tokenIdCollection.deleteOne(filter);
    }

    public static Token convertFromDocumentToTokenModel(Document tokenDoc) throws Exception {
        String tokenId = tokenDoc.get(TOKEN).toString();
        String userId = tokenDoc.get(USER_ID).toString();
        String ipLogin = tokenDoc.getString(IP_LOGIN);
        LocalDateTime time = (LocalDateTime) tokenDoc.get(TIME);
        return new Token(tokenId, userId, ipLogin, time);
    }

    public static boolean isValidToken(String token) throws Exception {
        Document filter = new Document(TOKEN, token);
        return tokenIdCollection.find(filter).first() != null;
    }

    public static String getUserId(String token) {
        Document filter = new Document(TOKEN, token);
        return (String) tokenIdCollection.find(filter).limit(1).first().get(USER_ID);
    }

    public static String getIpLogin(String token){
        Document filter = new Document(TOKEN, token);
        return (String) tokenIdCollection.find(filter).limit(1).first().get(IP_LOGIN);
    }

    public static long getRecentActivity(String token) throws Exception{
        Document filter = new Document(TOKEN, token);
        return (long) tokenIdCollection.find(filter).limit(1).first().get(RECENT_ACTIVITY);
    }

    public static void updateRecentActivity(String token) throws Exception{
        Document filter = new Document(TOKEN, token);
        LocalDateTime time = LocalDateTime.now();
        tokenIdCollection.updateOne(filter, new Document("$set", new Document(RECENT_ACTIVITY, time)));
    }

    public static void deleteNonActiveSessions(long timePeriod) throws Exception{
        LocalDateTime timeCheck = LocalDateTime.now();
        timeCheck = timeCheck.minusMinutes(timePeriod);
        Document condition = new Document(TIME, new Document("$lte", timeCheck));
        tokenIdCollection.deleteMany(condition);
    }
}
