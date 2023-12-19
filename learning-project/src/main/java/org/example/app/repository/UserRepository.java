package org.example.app.repository;

import com.mongodb.InsertOptions;
import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;
import org.example.app.configuration.databaseconfig.MongoConfig;
import org.example.app.constant.ApiName;
import org.example.app.exception.BusinessException;
import org.example.app.model.User;

import static org.example.app.constant.ExceptionCode.*;

import org.bson.Document;
import org.example.app.model.dto.PostDTO;
import org.example.app.model.dto.UserDTO;

import static org.example.app.constant.Role.*;

import javax.print.Doc;
import javax.swing.event.DocumentEvent;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.ObjDoubleConsumer;

public class  UserRepository {
    private static final String USERNAME_ID = "username";
    private static final String PASSWORD_ID = "password";
    private static final String NAME_ID = "name";
    private static final String AGE_ID = "age";
    private static final String ROLE_ID = "role";
    private static final String USER_ID = "_id";
    private static final String ADDRESS_ID = "address";
    private static final String DATABASE_NAME = "company";
    private static final String COLLECTION_NAME = "users";
    private static final MongoCollection<Document> usersCollection = MongoConfig.getDataBaseCollection(DATABASE_NAME, COLLECTION_NAME);
    public static String addUser(String username, String password, String name, int age, int role, String address){
        Document filter = new Document(USERNAME_ID, username)
                                        .append(PASSWORD_ID, password)
                                        .append(NAME_ID, name)
                                        .append(AGE_ID, age)
                                        .append(ROLE_ID, role)
                                        .append(ADDRESS_ID, address);
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

    public static String getName(String id) {
        Document condition = new Document(USER_ID, new ObjectId(id));
        return (String) usersCollection.find(condition).limit(1).first().get(NAME_ID);
    }

    public static int getAge(String id) {
        Document condition = new Document(USER_ID, new ObjectId(id));
        return (int) usersCollection.find(condition).limit(1).first().get(AGE_ID);
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
        int role = document.getInteger(ROLE_ID);
        String id = document.getObjectId(USER_ID).toString();
        String address = document.getString(ADDRESS_ID);

        return new User(username, password, name, age, role, id, address);
    }

    public static void changeAgeOfUser(String id, int ageChange) throws Exception{
        Document filter = new Document(USER_ID, new ObjectId(id));
        Document update = new Document("$inc", new Document(AGE_ID, ageChange));
        usersCollection.updateOne(filter, update);
    }

    public static void displayUser(User user) throws Exception{
        System.out.println(user.toString());
    }

    public static int getRole(String id) throws Exception{
        Document condition = new Document(USER_ID, new ObjectId(id));
        return (int) usersCollection.find(condition).limit(1).first().get(ROLE_ID);
    }

    public static UserDTO getUserDTO(String userId) throws Exception{
        Document filter = new Document(USER_ID, new ObjectId(userId));
        Document userDoc = usersCollection.find(filter).limit(1).first();
        return getUserDisplayFromDocument(userDoc);
    }

    public static ArrayList<UserDTO> getNormalUser(String name) throws Exception{
        ArrayList<UserDTO> listUser = new ArrayList<>();
        Document condition = new Document(NAME_ID,name).append(ROLE_ID, USER);
        for(Document doc : usersCollection.find(condition)){
            UserDTO postDTO = getUserDisplayFromDocument(doc);
            listUser.add(postDTO);
        }
        return listUser;
    }

    public static ArrayList<UserDTO> getUserAndAdminByName(String name) throws Exception{
        ArrayList<UserDTO> listUser = new ArrayList<>();
        Document condition = new Document(NAME_ID, name);
        for(Document doc : usersCollection.find(condition)){
            UserDTO userDTO = getUserDisplayFromDocument(doc);
            listUser.add(userDTO);
        }
        return listUser;
    }

    public static UserDTO getUserDisplayFromDocument(Document document) throws Exception{
        String name = document.getString(NAME_ID);
        int role = document.getInteger(ROLE_ID);
        int age = document.getInteger(AGE_ID);
        String address = document.getString(ADDRESS_ID);

        return new UserDTO(name, role, age, address);
    }

    public static List<UserDTO> getListUsers(List<String> listUserIds) throws Exception {
        List<UserDTO> result = new ArrayList<>();
        List<ObjectId> objectIds = new ArrayList<>();
        for(String userId : listUserIds){
            objectIds.add(new ObjectId(userId));
        }
        Document query = new Document(USER_ID, new Document("$in", objectIds));
        List<Document> users = usersCollection.find(query).into(new ArrayList<>());
        Iterator<Document> usersIterator = users.iterator();
        while(usersIterator.hasNext()){
            UserDTO userDTO = getUserDisplayFromDocument(usersIterator.next());
            result.add(userDTO);
        }
        return result;
    }
}