package org.example.app;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.example.app.configuration.databaseconfig.MongoConfig;
import org.example.app.servlet.user.SeverHolder;
import org.example.app.thread.user.LogoutPeriod;

public class Main {

    public static void main(String[] args) throws Exception{


        String connectionString = "mongodb://localhost:27017";
        MongoConfig.connect(connectionString);
        LogoutPeriod logoutPeriod = new LogoutPeriod();
        logoutPeriod.start();
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.addServlet(new ServletHolder(new SeverHolder()), "/user");
        server.setHandler(context);
        server.start();





        }

    }



