package com.adarsh.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import static java.lang.System.out;
/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MyServletTwo extends HttpServlet {
    static {
        out.print("MyServletTwo static block ");
    }

    {
        out.print("MyServletTwo instance block ");
    }

    public MyServletTwo() {
        out.print("MyServletTwo constructor ");
    }

    @Override
    public void init() {
        out.print("MyServletTwo init() ");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("<br/>MyServletTwo doGet() start ");
        HttpSession httpSession = request.getSession();
        Enumeration httpSessionEnum = httpSession.getAttributeNames();
        while (httpSessionEnum.hasMoreElements()) {
            String sessionName = (String) httpSessionEnum.nextElement();
            pw.println("<br/>Session Name =>" + sessionName);
            pw.println(" Session Value =>" + httpSession.getAttribute(sessionName));
        }


        pw.println("<br/>MyServletTwo doGet() end ");
    }

    @Override
    public void destroy() {
        out.print("MyServletTwo destroy ");
    }
}
