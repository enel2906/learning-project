package org.example.app;

import com.mongodb.client.ClientSession;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.types.ObjectId;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.example.app.configuration.databaseconfig.MongoConfig;
import org.example.app.controller.UserController;
import org.example.app.servlet.user.Post;
import org.example.app.servlet.user.Login;
import org.example.app.servlet.user.Signin;

import org.bson.Document;

import javax.print.Doc;

public class Main {

    public static void main(String[] args) throws Exception{


//        UserController.getInstance().addUser("minh123", "1234", "Minh", 20, "intern");
//        UserController.getInstance().addUser("Son12", "123456", "Sơn", 26, "leader");
//        UserController.getInstance().addUser("john123", "password123", "John Smith", 25, "employee");
//        UserController.getInstance().addUser("alice92", "securepwd", "Alice Johnson", 30, "manager");
//        UserController.getInstance().addUser("jenny456", "pass123", "Jenny Brown", 28, "employee");
//        UserController.getInstance().addUser("David789", "david1234", "David Lee", 35, "manager");
//        UserController.getInstance().addUser("sarah567", "sarahpass", "Sarah Williams", 26, "intern");
//        UserController.getInstance().addUser("alex90", "alexpass", "Alex Green", 29, "employee");
//        UserController.getInstance().addUser("emily321", "emilypwd", "Emily Davis", 31, "manager");
//        UserController.getInstance().addUser("michael555", "mikepass", "Michael Johnson", 27, "intern");
//
//        Server server = new Server(8080);
//        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        context.setContextPath("/");
//        context.addServlet(new ServletHolder(new Login()), "/login");
//        context.addServlet(new ServletHolder(new Post()), "/user");
//        context.addServlet(new ServletHolder(new Signin()), "/signin");
//        server.setHandler(context);
//        server.start();

        String connectionString = "mongodb://localhost:27017";
        MongoConfig.connect(connectionString);
        MongoCollection<Document> collection = MongoConfig.getDataBaseCollection();

//        Document gf = new Document("username","anh2906")
//                                        .append("password", "mia123")
//                                        .append("name","Ánh")
//                                        .append("age",20)
//                                        .append("role", "doctor").append("university","hpmu");
//        collection.insertOne(gf);
//
        Document filter = new Document("name", "Sơn");
        collection.updateMany(filter, new Document("$set", new Document("age", 26)));
        Document condition = new Document("age", new Document("$lte", 25));

        for(Document doc : collection.find(condition).projection(new Document("_id", false))){
            System.out.println(doc.toJson());
        }

    }

}

