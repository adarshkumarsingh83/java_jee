package com.espark.adarsh;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@WebServlet(value = "/secured"
        , name = "SecuredServlet"
        , description = "My SecuredServlet Servlet"
        , displayName = "SecuredServlet"
        , loadOnStartup = 1)
@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = {
                        "admin"
                }),
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = {
                        "admin"
                }),
                @HttpMethodConstraint(value = "POST")
        })
public class SecuredServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.write("Servlet basic authentication annotation configuration: secured servlet");
        log.info("SecuredServlet doGet() executed ");
    }

}
