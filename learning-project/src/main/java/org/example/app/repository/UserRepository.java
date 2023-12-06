package org.example.app.repository;

import com.mongodb.InsertOptions;
import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;
import org.example.app.configuration.databaseconfig.MongoConfig;
import org.example.app.model.User;

import org.bson.Document;

import javax.print.Doc;
import javax.swing.event.DocumentEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class  UserRepository {
    private static final String USERNAME_ID = "username";
    private static final String PASSWORD_ID = "password";
    private static final String NAME_ID = "name";
    private static final String AGE_ID = "age";
    private static final String ROLE_ID = "role";
    private static final String USER_ID = "_id";
    private static final String DATABASE_NAME = "company";
    private static final String COLLECTION_NAME = "users";
    private static MongoCollection<Document> usersCollection = MongoConfig.getDataBaseCollection(DATABASE_NAME, COLLECTION_NAME);
    public static String addUser(String username, String password, String name, int age, String role){
        Document filter = new Document(USERNAME_ID, username)
                                        .append(PASSWORD_ID, password)
                                        .append(NAME_ID, name)
                                        .append(AGE_ID, age)
                                        .append(ROLE_ID, role);
        usersCollection.insertOne(filter);
        return filter.get(USER_ID).toString();
    }

    public static void removeUser(String id) {
        Document filter = new Document(USER_ID, new ObjectId(id));
        usersCollection.findOneAndDelete(filter);
    }

    public static Object getUsername(String id) {
        Document filter = new Document(USER_ID, new ObjectId(id));
        Document projection = new Document(USER_ID, false).append(USERNAME_ID, true);
        return usersCollection.find(filter).projection(projection);
    }

    public static Object getPassword(String id) {
        Document filter = new Document(USER_ID, new ObjectId(id));
        Document projection = new Document(USER_ID, false).append(PASSWORD_ID, true);
        return usersCollection.find(filter).projection(projection);
    }

    public static Object getName(String id) {
        Document filter = new Document(USER_ID, new ObjectId(id));
        Document projection = new Document(USER_ID, false).append(USER_ID, true);
        return usersCollection.find(filter).projection(projection);
    }

    public static Object getAge(String id) {
        Document filter = new Document(USER_ID, new ObjectId(id));
        Document projection = new Document(USER_ID, false).append(AGE_ID, true);
        return usersCollection.find(filter).projection(projection);
    }

    public static Object getRole(String id) {
        Document filter = new Document(USER_ID, new ObjectId(id));
        Document projection = new Document(USER_ID, false).append(ROLE_ID, true);
        return usersCollection.find(filter).projection(projection);
    }

    public static User findUserByID(String id) throws Exception{
        Document filter = new Document(USER_ID, new ObjectId(id));
        Document userDoc = usersCollection.find(filter).limit(1).first();
        return convertFromDocument(userDoc);
    }

    public static User findUserByUsernameAndPassword(String username, String password) throws Exception {
        Document filter = new Document(USERNAME_ID, username).append(PASSWORD_ID, password);
        Document userDoc = usersCollection.find(filter).limit(1).first();
        assert userDoc != null;
        return convertFromDocument(userDoc);
    }
    public static ArrayList<User> findUserByAge(int age) throws Exception{
        ArrayList<User> users = new ArrayList<>();
        Document condition = new Document("age", age);
        for(Document userDoc : usersCollection.find(condition)){
            User user = convertFromDocument(userDoc);
            users.add(user);
        }
        return users;
    }
    public static User convertFromDocument(Document document) throws Exception{
        String username = document.getString(USERNAME_ID);
        String password = document.getString(PASSWORD_ID);
        String name = document.getString(NAME_ID);
        int age = document.getInteger(AGE_ID);
        String role = document.getString(ROLE_ID);
        String id = document.getObjectId(USER_ID).toString();

        return new User(username, password, name, age, role, id);
    }

    public static void changeAgeOfUser(String id, int ageChange) throws Exception{
        Document filter = new Document(USER_ID, new ObjectId(id));
        Document update = new Document("$inc", new Document(AGE_ID, ageChange));
        usersCollection.updateOne(filter, update);
    }

    public void displayUser(User user) {
        System.out.println(user.toString());
    }



}