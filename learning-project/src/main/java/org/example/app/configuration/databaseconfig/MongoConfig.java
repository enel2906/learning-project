package org.example.app.configuration.databaseconfig;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
public class MongoConfig {
    private static String connectionString;
    private static MongoClient mongoClient;

    public static String getConnectionString() {
        return connectionString;
    }

    public static void setConnectionString(String connectionString) {
        MongoConfig.connectionString = connectionString;
    }

    public static MongoCollection<Document> getDataBaseCollection(String databaseName, String collectionName) {
        return mongoClient.getDatabase(databaseName).getCollection(collectionName);
    }

    public static void connect(String connectionString){
        setConnectionString(connectionString);
        mongoClient = MongoClients.create(connectionString);
    }


}
