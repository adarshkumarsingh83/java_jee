package com.adarsh.servlet;

import javax.servlet.ServletException;
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
public class MyServletOne extends HttpServlet {

    static {
        out.println("MyServletOne static block ");
    }

    {
        out.println("MyServletOne instance block ");
    }

    public MyServletOne() {
        out.println("MyServletOne constructor ");
    }

    @Override
    public void init() {
        out.println("MyServletOne init() ");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter pw = response.getWriter();
        pw.println("<br/>MyServletOne doGet() start ");
        request.setAttribute("Response Attribute 1", "Adarsh kumar singh");
        request.setAttribute("Response Attribute 2", "Amit kumar singh");
        request.setAttribute("Response Attribute 3", "Amritesh kumar singh");
        request.setAttribute("Response Attribute 4", "Radha singh");
        request.getRequestDispatcher("/myServlet2").forward(request, response);
        pw.println("<br/>MyServletOne doGet() end ");
    }

    @Override
    public void destroy() {
        out.println("MyServletOne destroy() ");
    }
}
