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
        out.println("MyServletOne init()");
    }


    @Override
    protected void doGet(HttpServletRequest requestObject, HttpServletResponse responseObject)
            throws ServletException, IOException {
        PrintWriter pw = responseObject.getWriter();
        pw.print("<br/>MyServletOne goGET() start ");
        out.println("MyServletOne doGET() start ");

        requestObject.getRequestDispatcher("/myServlet2").forward(requestObject, responseObject);

        pw.print("<br/>MyServletOne goGET() end ");
        out.println("MyServletOne doGET() end ");
    }

    @Override
    public void destroy() {
        out.println("MyServletOne destroyed() ");
    }
}
