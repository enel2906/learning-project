package org.example.app.servlet.user;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.app.api.user.LoginAPI;
import org.example.app.request.Request;
import org.example.app.request.user.LoginRequest;
import org.example.app.response.Response;
import org.example.app.response.user.LoginResponse;
import org.example.app.servlet.CommonServlet;

import java.awt.*;
import java.io.IOException;

import static java.awt.SystemColor.text;

public class Login extends CommonServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("welcome");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        LoginRequest loginRequest = new LoginRequest(username, password);
        Request requestLogin = new Request(loginRequest);
        Response responseLogin = LoginAPI.getInstance().execute(requestLogin);

        resp.getWriter().println(username);
        resp.getWriter().println("Token: " + ((LoginResponse) responseLogin.getResponseData()).getToken());
    }
}
