package org.example.app.servlet.user;

import com.google.gson.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.example.app.api.CommonAPI;

import org.example.app.api.APIManager;
import org.example.app.util.Util;

import static org.example.app.constant.ApiName.*;


import java.io.BufferedReader;
import java.io.IOException;

public class SeverHolder extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("Helooo");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader reader = req.getReader();
        Gson gson = new Gson();

        JsonElement requestBody = JsonParser.parseReader(reader);
        JsonObject object = requestBody.getAsJsonObject();

        String apiName = (String) object.get(NAME_KEY.name).getAsString();
        CommonAPI api = APIManager.getAPI(apiName);
        if(Util.isNull(api)){
            System.out.println("api name is nullllllllllllllll");
        }
        resp.setContentType("application/json");
        resp.getWriter().println(gson.toJson(api.execute(object)));
    }
}
