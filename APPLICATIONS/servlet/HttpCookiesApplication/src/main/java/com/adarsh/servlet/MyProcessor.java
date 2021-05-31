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
public class MyProcessor extends HttpServlet {

    static {
        out.println("MyProcessor static block");
    }

    {
        out.println("MyProcessor instance block");
    }

    public MyProcessor() {
        out.println("MyProcessor constructor");
    }

    public void init() {
        out.println("MyProcessor init()");
    }


    @Override
    protected void doGet(HttpServletRequest requestObject, HttpServletResponse responseObject)
            throws ServletException, IOException {
        PrintWriter pw = responseObject.getWriter();
        Cookie[] c = requestObject.getCookies();
        if (c != null) {
            for (int i = 0; i < c.length; i++) {
                pw.println("<br/>Cookies Name " + c[i].getName() + " Cookies Value " + c[i].getValue());
            }
        }
    }

    @Override
    public void destroy() {
        out.println("MyProcessor destroy()");
    }
}
