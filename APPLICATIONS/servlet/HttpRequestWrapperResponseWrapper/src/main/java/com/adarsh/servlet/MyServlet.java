package com.adarsh.servlet;

import javax.servlet.ServletConfig;
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
    private static final long serialVersionUID = 1L;


    public MyServlet() {
        super();
        out.println("MyServlet constructor");
    }

    static {
        out.println("MyServlet static block");
    }

    {
        out.println("MyServlet instacne block");
    }

    @Override
    public void init(ServletConfig servletConfig) {
        out.println("MyServlet init()");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        out.println("MyServlet service() start ");
        response.getWriter().println("<Br> MyServlet service() Executed " + request.getParameter("name"));
        response.getWriter().println("<Br> MyServlet service() Executed " + request.getAttribute("name"));
        out.println("MyServlet service() end");
    }

    @Override
    public void destroy() {
        out.println("MyServlet destroy()");
    }

}
