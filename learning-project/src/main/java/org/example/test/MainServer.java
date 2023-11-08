package org.example.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.io.IOException;

public class MainServer {
    public static void main(String[] args) throws Exception {
        // Khởi tạo server
        Server server = new Server(8090);

        // Tạo ServletContextHandler
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        // Đăng ký MyServlet với ServletContextHandler
        context.addServlet(new ServletHolder(new MyServlet()), "/myservlet");

        // Kết nối ServletContextHandler với server
        server.setHandler(context);

        // Khởi động server
        server.start();
        server.join();
    }

    // Lớp MyServlet
    public static class MyServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("application/json");
            response.getWriter().println("Hello from MyServlet!");
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response){
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            
        }
    }
}