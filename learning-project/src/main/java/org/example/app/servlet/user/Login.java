package org.example.app.servlet.user;


import com.google.gson.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.app.api.user.LoginAPI;
import org.example.app.request.Request;
import org.example.app.request.user.LoginRequest;
import org.example.app.response.Response;

import java.io.BufferedReader;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Please enter your information to login");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       BufferedReader reader = req.getReader();
       JsonElement requestBody = JsonParser.parseReader(reader);
       JsonObject object = requestBody.getAsJsonObject();

        Gson gson = new Gson();

        String username = object.get("username").getAsString();
        String password = object.get("password").getAsString();

        LoginRequest loginRequest = new LoginRequest(username, password);
        Request request = new Request(loginRequest);
        Response response = LoginAPI.getInstance().execute(request);

        resp.setContentType("application/json");
        resp.getWriter().println(gson.toJson(response));



    }

}
