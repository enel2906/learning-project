package org.example.app.configuration.databaseconfig;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
public class MongoConfig {
    private static String connectionString;
    private static MongoDatabase dataBase;

    public static String getConnectionString() {
        return connectionString;
    }

    public static void setConnectionString(String connectionString) {
        MongoConfig.connectionString = connectionString;
    }

    public static MongoCollection<Document> getDataBaseCollection(String collectionName) {
        return dataBase.getCollection(collectionName);
    }

    public static void connect(String connectionString){
        setConnectionString(connectionString);

        MongoClient mongoClient = MongoClients.create(connectionString);
        dataBase = mongoClient.getDatabase("company");
        dataBase.getCollection("tokenIds").deleteMany(new Document("_id", new Document("$exists", true)));
    }


}
