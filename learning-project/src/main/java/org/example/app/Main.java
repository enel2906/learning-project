package org.example.app;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.example.app.controller.UserController;
import org.example.app.servlet.user.Post;
import org.example.app.servlet.user.Login;
import org.example.app.servlet.user.Signin;

public class Main {

    public static void main(String[] args) throws Exception{


        UserController.getInstance().addUser("minh123", "1234", "Minh", 20, "intern");
        UserController.getInstance().addUser("Son12", "123456", "Sơn", 26, "leader");
        UserController.getInstance().addUser("john123", "password123", "John Smith", 25, "employee");
        UserController.getInstance().addUser("alice92", "securepwd", "Alice Johnson", 30, "manager");
        UserController.getInstance().addUser("jenny456", "pass123", "Jenny Brown", 28, "employee");
        UserController.getInstance().addUser("David789", "david1234", "David Lee", 35, "manager");
        UserController.getInstance().addUser("sarah567", "sarahpass", "Sarah Williams", 26, "intern");
        UserController.getInstance().addUser("alex90", "alexpass", "Alex Green", 29, "employee");
        UserController.getInstance().addUser("emily321", "emilypwd", "Emily Davis", 31, "manager");
        UserController.getInstance().addUser("michael555", "mikepass", "Michael Johnson", 27, "intern");

        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.addServlet(new ServletHolder(new Login()), "/login");
        context.addServlet(new ServletHolder(new Post()), "/user");
        context.addServlet(new ServletHolder(new Signin()), "/signin");
        server.setHandler(context);
        server.start();

//        LogoutPeriod logoutPeriod = new LogoutPeriod();
//        logoutPeriod.start();


//        LoginRequest loginRequestMinh123 = new LoginRequest("minh123", "1234");
//        Request requestMinh123 = new Request(loginRequestMinh123);
//        Response responseLoginMinh123 = LoginAPI.getInstance().execute(requestMinh123);
//        System.out.println(responseLoginMinh123.toString());
//
//
//        LogoutRequest logoutRequestDavid789 = new LogoutRequest(tokenDavid789);
//        Request requestLogoutDavid789 = new Request(logoutRequestDavid789);
//        Response responseLogoutDavid789 = LogoutAPI.getInstance().execute(requestLogoutDavid789);
//        System.out.println(responseLogoutDavid789.toString());





    }

}

