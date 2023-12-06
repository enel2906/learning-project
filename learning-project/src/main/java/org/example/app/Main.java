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
import org.example.app.repository.UserRepository;
import org.example.app.servlet.user.Post;
import org.example.app.servlet.user.Login;
import org.example.app.servlet.user.Signin;

import org.bson.Document;

import javax.print.Doc;

public class Main {

    public static void main(String[] args) throws Exception{


        String connectionString = "mongodb://localhost:27017";
        MongoConfig.connect(connectionString);
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.addServlet(new ServletHolder(new Login()), "/login");
        context.addServlet(new ServletHolder(new Post()), "/user");
        context.addServlet(new ServletHolder(new Signin()), "/signin");
        server.setHandler(context);
        server.start();





        }

    }



