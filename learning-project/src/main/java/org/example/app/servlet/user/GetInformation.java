package org.example.app.servlet.user;

import com.google.gson.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;
import org.eclipse.jetty.util.IO;
import org.example.app.api.user.GetInforAPI;
import org.example.app.request.Request;
import org.example.app.request.user.InforRequest;
import org.example.app.response.Response;
import org.example.app.response.user.LoginResponse;
import org.example.app.servlet.CommonServlet;


import java.io.BufferedReader;
import java.io.IOException;

public class GetInformation extends CommonServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Gson gson = new Gson();

        JsonElement requestBody = JsonParser.parseReader(reader);
        JsonArray jsonArray = requestBody.getAsJsonArray();

        for (JsonElement jsonElement : jsonArray) {
            JsonObject object = jsonElement.getAsJsonObject();



    InforRequest inforRequest = new InforRequest(token);
    Request request = new Request(inforRequest);
    Response response = GetInforAPI.getInstance().execute(request);

    String jsonResponse = gson.toJson(response.getResponseData());

            resp.setContentType("application/json");
            resp.getWriter().println(object.get("token"));
        }

            /*
            TODO getRequest
            TODO đọc thông tin từ request > String >  để đưa về dạng Json
            TODO tu dang Json dua ve request
            TODO  Tuy vao api_name thuc hien execute > response
            TODO  dua response ve dang Json
            TODO  tra response duoi dang Json
            */
    }
}


/*
{
    "token": "dhasfja"
},
{
    "token":"fskadf"
},
{
    "token":"jdasf";
}
 */
