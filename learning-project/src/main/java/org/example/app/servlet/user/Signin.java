package org.example.app.servlet.user;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.example.app.api.user.SigninAPI;
import org.example.app.request.Request;
import org.example.app.request.user.SigninRequest;
import org.example.app.response.Response;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

public class Signin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
        resp.setContentType("application/json");
        resp.getWriter().println("Please enter your information to sign in");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        JsonElement requestBody = JsonParser.parseReader(reader);
        JsonObject object = requestBody.getAsJsonObject();

        Gson gson = new Gson();
        Response response = SigninAPI.getINSTANCE().execute(object);

        resp.setContentType("application/json");
        resp.getWriter().println(gson.toJson(response));
    }
}
