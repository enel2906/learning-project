package org.example.app.repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.example.app.configuration.databaseconfig.MongoConfig;
import org.example.app.constant.Role;
import org.example.app.model.Post;
import org.example.app.model.dto.PostDTO;
;import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    private static final String DATABASE_NAME = "company";
    private static final String COLLECTION_NAME = "posts";
    private static final String POST_ID = "_id";
    private static final String USER_ID = "user_id";
    private static final String CONTENT = "content";
    private static final String TYPE = "type";
    private static final MongoCollection<Document> postCollection = MongoConfig.getDataBaseCollection(DATABASE_NAME, COLLECTION_NAME);
    public static String addNewPost(String userId, String author, String content, String type) throws Exception{
        Document filter = new Document(TYPE, type)
                .append(USER_ID, userId)
                .append(CONTENT, content);
        postCollection.insertOne(filter);
        System.out.println(filter.get(POST_ID).toString());
        return filter.get(POST_ID).toString();
    }

    public static void deletePost(String id) throws Exception{
        Document condition = new Document(POST_ID, new ObjectId(id));
        postCollection.deleteOne(condition);
    }

    public static ArrayList<Post> getAllPost(String userId) throws Exception{
        ArrayList<Post> listPost = new ArrayList<>();
        Document filter = new Document(USER_ID, userId);
        for(Document doc : postCollection.find(filter)){
            Post post = convertFromDocument(doc);
            listPost.add(post);
        }
        return listPost;
    }


    public static ArrayList<PostDTO> getPostsDisplayById(String userId) throws Exception{
        ArrayList<PostDTO> listPost = new ArrayList<>();
        Document filter = new Document(USER_ID, userId);
        for(Document doc : postCollection.find(filter)){
            PostDTO postDTO = getPostDisplay(doc);
            listPost.add(postDTO);
        }
        return listPost;
    }
    public static Post findPostById(String postId) throws Exception{
        Document filter = new Document(POST_ID, new ObjectId(postId));
        Document doc = postCollection.find(filter).limit(1).first();
        assert doc != null;
        return convertFromDocument(doc);
    }

    public static PostDTO findPostDisplayById(String postId) throws Exception{
        Document filter = new Document(POST_ID, new ObjectId(postId));
        Document doc = postCollection.find(filter).limit(1).first();
        assert doc != null;
        return getPostDisplay(doc);
    }
    public static Post convertFromDocument(Document document) throws Exception {
        String postId = document.get(POST_ID).toString();
        String userId = document.getString(USER_ID);
        String content = document.getString(CONTENT);
        String type = document.getString(TYPE);

        return new Post(postId, userId, content, type);
    }

    public static PostDTO getPostDisplay(Document document) throws Exception {
        String author = document.getString(USER_ID);
        String content = document.getString(CONTENT);
        String type = document.getString(TYPE);

        return new PostDTO(author, type , content);
    }

    public static boolean existPostOfUserId(String postId, String userId) throws Exception{
        Document condition = new Document(POST_ID, new ObjectId(postId)).append(USER_ID, userId);
        return postCollection.find(condition).first() != null;
    }
    public static List<String> getListPostId(String userId) throws Exception {
        List<String> result = new ArrayList<>();
        Document query = new Document(USER_ID, userId);
        for(Document post : postCollection.find(query)){
            String postId = post.get(POST_ID).toString();
            result.add(postId);
        }
        return result;
    }
    public static boolean isValidPostId(String postId) throws Exception {
        Document query = new Document(POST_ID, new ObjectId(postId));
        FindIterable<Document> result = postCollection.find(query).limit(1);
        return result.iterator().hasNext();
    }
}
