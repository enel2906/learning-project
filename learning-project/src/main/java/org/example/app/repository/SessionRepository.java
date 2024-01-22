package org.example.app.repository;

import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;
import org.eclipse.jetty.server.session.Session;
import org.example.app.configuration.databaseconfig.MongoConfig;
import org.example.app.model.Token;

import org.bson.Document;
import org.example.app.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class SessionRepository {
    private final MongoTemplate mongoTemplate;
    private final MongoCollection<Document> tokenIdCollection;

    public SessionRepository(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
        tokenIdCollection = mongoTemplate.getCollection(COLLECTION_NAME);
    }
    private static final String SESSION_ID = "_id";
    private static final String TOKEN = "token";
    private static final String USER_ID = "user_id";
    private static final String IP_LOGIN = "ipLogin";
    private static final String TIME = "time_login";
    private static final String COLLECTION_NAME ="sessions";
    private static final String RECENT_ACTIVITY = "recent_active";
    private static final String ROLE = "role";;

    public String createToken(String id, String ipLogin, int role) throws Exception{
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

    public int countIpLogin(String id) throws Exception{
        Document idFilter = new Document(USER_ID, id);
        return (int) tokenIdCollection.countDocuments(idFilter);
    }

    public long getTime(String tokenId) throws Exception {
        Document filter = new Document("_id", new ObjectId(tokenId));
        return (long) tokenIdCollection.find(filter).limit(1).first().get(TIME);
    }

    public int getRoleByToken(String token) throws Exception{
        Document condition = new Document(TOKEN, token);
        return (int) tokenIdCollection.find(condition).limit(1).first().get(ROLE);
    }

    public void removeToken(String tokenId) {
        Document filter = new Document(TOKEN, tokenId);
        tokenIdCollection.deleteOne(filter);
    }

    public Token convertFromDocumentToTokenModel(Document tokenDoc) throws Exception {
        String tokenId = tokenDoc.get(TOKEN).toString();
        String userId = tokenDoc.get(USER_ID).toString();
        String ipLogin = tokenDoc.getString(IP_LOGIN);
        LocalDateTime time = (LocalDateTime) tokenDoc.get(TIME);
        return new Token(tokenId, userId, ipLogin, time);
    }

    public boolean isValidToken(String token) throws Exception {
        Document filter = new Document(TOKEN, token);
        return tokenIdCollection.find(filter).first() != null;
    }

    public String getUserId(String token) {
        Document filter = new Document(TOKEN, token);
        return (String) tokenIdCollection.find(filter).limit(1).first().get(USER_ID);
    }

    public String getIpLogin(String token){
        Document filter = new Document(TOKEN, token);
        return (String) tokenIdCollection.find(filter).limit(1).first().get(IP_LOGIN);
    }

    public long getRecentActivity(String token) throws Exception{
        Document filter = new Document(TOKEN, token);
        return (long) tokenIdCollection.find(filter).limit(1).first().get(RECENT_ACTIVITY);
    }

    public void updateRecentActivity(String token) throws Exception{
        Document filter = new Document(TOKEN, token);
        LocalDateTime time = LocalDateTime.now();
        tokenIdCollection.updateOne(filter, new Document("$set", new Document(RECENT_ACTIVITY, time)));
    }

    public void deleteNonActiveSessions(long timePeriod) throws Exception{
        LocalDateTime timeCheck = LocalDateTime.now();
        timeCheck = timeCheck.minusMinutes(timePeriod);
        Document condition = new Document(TIME, new Document("$lte", timeCheck));
        tokenIdCollection.deleteMany(condition);
    }
    public Token findById(String token) throws Exception{
        Document query = new Document(TOKEN, token);
        Document tokenDoc = tokenIdCollection.find(query).limit(1).first();
        assert tokenDoc != null;
        return convertFromDocumentToTokenModel(tokenDoc);
    }

    public void deleteAllSession() throws Exception{
        Document query = new Document();
        tokenIdCollection.deleteMany(query);
    }

}
