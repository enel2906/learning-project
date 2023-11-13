package org.example.app.servlet.user;

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


import java.io.IOException;

    public class GetInformation extends CommonServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            System.out.println("getInforrrrrrrrrrrrrrrr");
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String token = req.getParameter("token");
            req.getH
            InforRequest inforRequest = new InforRequest(token);
            Request request = new Request(inforRequest);
            Response response = GetInforAPI.getInstance().execute(request);

            resp.getWriter().println(response.getResponseData().toString());

            /*
            TODO getRequest
            TODO doc thong tin request > String >  de dua ve dang Json
            TODO tu dang Json dua ve request
            TODO  Tuy vao api_name thuc hien execute > response
            TODO  dua response ve dang Json
            TODO  tra response duoi dang Json
            */
        }
}
