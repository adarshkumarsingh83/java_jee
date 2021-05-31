package com.adarsh.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        out.println("MyServletTwo static block ");
    }

    {
        out.println("MyServletTwo instance block ");
    }

    public MyServletTwo() {
        out.println("MyServletTwo constructor ");
    }

    @Override
    public void init() {
        out.println("MyServletTwo init() ");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("<br/>MyServletTwo doGet() start ");
        Enumeration requestAttribute = request.getAttributeNames();
        while (requestAttribute.hasMoreElements()) {
            String attributeName = (String) requestAttribute.nextElement();
            pw.println("<br/>ATTRIBUTE NAME :" + attributeName + " ATTRIBUTE VALUE " + request.getAttribute(attributeName));
        }
        pw.println("<br/>MyServletTwo doGet() end ");
    }

    @Override
    public void destroy() {
        out.println("MyServletTwo destroy() ");
    }
}
