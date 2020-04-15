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
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    static {
        out.println("MyServlet static block");
    }

    {
        out.println("MyServlet instance block");
    }

    public MyServlet() {
        super();
        out.println("MyServlet constructor");
    }

    @Override
    public void init() {
        out.println("MyServlet init()");
    }

    @Override
    public void destroy() {
        out.println("MyServlet destroy()");
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        out.println("MyServlet doGet() start");
        pw.println("<br/> this is MyServlet ");

        out.println("MyServlet doGet() end");
    }

}
