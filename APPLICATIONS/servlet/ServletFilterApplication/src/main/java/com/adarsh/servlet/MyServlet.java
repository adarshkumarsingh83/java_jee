package com.adarsh.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.System.out;

/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MyServlet extends HttpServlet {

    static {
        out.println("MyServlet class static block");
    }

    {
        out.println("MyServlet class instance block");
    }

    public MyServlet() {
        out.println("MyServlet class constructor");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        out.println("MyServlet doGet() start");
        resp.getWriter().println("MyServlet ");
        out.println("MyServlet doGet() end");
    }


}
