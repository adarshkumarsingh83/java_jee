package com.adarsh.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;
/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MyServlet extends HttpServlet {
    static {
        out.println("MyServlet static block");
    }

    {
        out.println("MyServlet instacne block");
    }

    public MyServlet() {
        out.println("MyServlet constructor ");
    }

    @Override
    public void init() {
        out.println("MyServlet init()");
    }


    @Override
    protected void doGet(HttpServletRequest requestObject, HttpServletResponse responseObject)
            throws ServletException, IOException {
        PrintWriter pw = responseObject.getWriter();
        pw.println("<br/>MyServlet ");
        responseObject.addCookie(new Cookie("Cookie1", "radha"));
        responseObject.addCookie(new Cookie("Cookie2", "amit"));
        responseObject.addCookie(new Cookie("Cookie3", "adarsh"));

        responseObject.sendRedirect("/HttpCookiesApplication/myProcessor");
    }

    @Override
    public void destroy() {
        out.println("MyServlet destroy()");
    }
}
