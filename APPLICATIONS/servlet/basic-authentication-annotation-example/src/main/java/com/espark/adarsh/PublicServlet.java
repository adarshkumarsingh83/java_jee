package com.espark.adarsh;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/un-secured"
        , name = "PublicServlet"
        , description = "My PublicServlet Servlet"
        , displayName = "PublicServlet"
        , loadOnStartup = 1)
public class PublicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.write("Servlet basic authentication annotation configuration: public servlet");
    }
}
