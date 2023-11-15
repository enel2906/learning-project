package org.example.app.servlet.user;

import com.google.gson.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.example.app.api.user.*;
import org.example.app.request.Request;
import org.example.app.request.RequestData;
import org.example.app.request.user.InforRequest;
import org.example.app.request.user.LogoutRequest;
import org.example.app.request.user.UpdateAgeRequest;
import org.example.app.response.Response;
import org.example.app.util.Util;

import static org.example.app.constant.ApiName.*;


import java.io.BufferedReader;
import java.io.IOException;

public class Post extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Gson gson = new Gson();

        JsonElement requestBody = JsonParser.parseReader(reader);
        JsonObject object = requestBody.getAsJsonObject();

        String apiName = (String) object.get(NAME_KEY).getAsString();
        CommonAPI api = APIManager.getAPI(apiName);
        if(Util.isNull(api)){

        }
        Response response = api.execute(object);
        resp.setContentType("application/json");

        resp.getWriter().println(gson.toJson(response));
    }


}
