package org.example.app.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.example.app.configuration.databaseconfig.MongoConfig;
import org.example.app.model.LikedInfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LikeInforRepository {
    private final MongoTemplate mongoTemplate;
    private final MongoCollection<Document> likedInforCollection;

    public LikeInforRepository(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
        likedInforCollection = mongoTemplate.getCollection(COLLECTION_NAME);
    }
    static final String COLLECTION_NAME = "likedinfors";
    static final String USER_ID = "user_id";
    static final String POST_ID = "post_id";
    public  void addNewLikeInfor(String userId, String postId) throws Exception {
        Document filter = new Document(USER_ID, userId).append(POST_ID, postId);
        likedInforCollection.insertOne(filter);
    }
    public boolean alreadyLiked(String userId, String postId) throws Exception {
        Document condition = new Document(USER_ID, userId).append(POST_ID, postId);
        FindIterable<Document> result = likedInforCollection.find(condition);
        return result.iterator().hasNext();
    }
    public long getNumLike( String postId) throws Exception {
        Document condition = new Document(POST_ID, postId);
        return likedInforCollection.countDocuments(condition);
    }
    public List<String> getLikedUsers(String postId) throws Exception {
        List<String> result = new ArrayList<>();
        Document query = new Document(POST_ID, postId);
        List<Document> listLikedInfor = likedInforCollection.find(query).into(new ArrayList<>());
        for(Document likedInfor : listLikedInfor){
            String userId = likedInfor.getString(USER_ID);
            result.add(userId);
        }
        return result;
    }
    public void deletePost(String postId) throws Exception {
        Document query = new Document(POST_ID, postId);
        likedInforCollection.deleteMany(query);
    }
    public boolean isValidPostId(String postId) throws Exception {
        Document query = new Document(POST_ID, postId);
        FindIterable<Document> result = likedInforCollection.find(query);
        return result.iterator().hasNext();
    }
}
