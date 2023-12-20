package org.example.app.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.example.app.configuration.databaseconfig.MongoConfig;
import org.example.app.model.LikedInfor;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

public class LikeInforRepository {
    private static final String DATABASE_NAME = "company";
    private static final String COLLECTION_NAME = "likedinfors";
    private static final String USER_ID = "user_id";
    private static final String POST_ID = "post_id";
    private static final MongoCollection<Document> likedInforCollection = MongoConfig.getDataBaseCollection(DATABASE_NAME, COLLECTION_NAME);
    public static void addNewLikeInfor(String userId, String postId) throws Exception {
        Document filter = new Document(USER_ID, userId).append(POST_ID, postId);
        likedInforCollection.insertOne(filter);
    }
    public static boolean alreadyLiked(String userId, String postId) throws Exception {
        Document condition = new Document(USER_ID, userId).append(POST_ID, postId);
        FindIterable<Document> result = likedInforCollection.find(condition);
        return result.iterator().hasNext();
    }
    public static long getNumLike( String postId) throws Exception {
        Document condition = new Document(POST_ID, postId);
        return likedInforCollection.countDocuments(condition);
    }
    public static List<String> getLikedUsers(String postId) throws Exception {
        List<String> result = new ArrayList<>();
        Document query = new Document(POST_ID, postId);
        List<Document> listLikedInfor = likedInforCollection.find(query).into(new ArrayList<>());
        for(Document likedInfor : listLikedInfor){
            String userId = likedInfor.getString(USER_ID);
            result.add(userId);
        }
        return result;
    }
    public static void deletePost(String postId) throws Exception {
        Document query = new Document(POST_ID, postId);
        likedInforCollection.deleteMany(query);
    }
    public static boolean isValidPostId(String postId) throws Exception {
        Document query = new Document(POST_ID, postId);
        FindIterable<Document> result = likedInforCollection.find(query);
        return result.iterator().hasNext();
    }
}
