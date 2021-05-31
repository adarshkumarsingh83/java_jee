package com.adarsh.servlet.http;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
public class MyHttpServlet extends HttpServlet {

    static {
        out.println("MyGenericServlet static block ");
    }

    {
        out.println("MyGenericServlet instance block ");
    }

    public MyHttpServlet() {
        out.println("MyGenericServlet constructor");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        work(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        work(req, resp);
    }

    private void work(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {
        out.println("MyGenericServlet service()");
        servletRequest.setAttribute("msg", "Hello  " + servletRequest.getParameter("userName"));
        servletRequest.getRequestDispatcher("/myJsp").forward(servletRequest, servletResponse);
    }

}
