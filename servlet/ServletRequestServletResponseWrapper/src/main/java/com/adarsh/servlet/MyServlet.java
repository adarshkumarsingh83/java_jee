package com.adarsh.servlet;

import javax.servlet.*;
import java.io.IOException;

import static java.lang.System.out;

/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MyServlet extends GenericServlet {
    private static final long serialVersionUID = 1L;

    static {
        out.println("MyServlet static block");
    }

    {
        out.println("MyServlet instance block");
    }

    public MyServlet() {
        super();
        out.println("MyServlet Constructor");
    }

    public void init(ServletConfig servletConfig) {
        out.println("MyServlet init()");
    }


    public void destroy() {
        out.println("MyServlet destroy()");
    }

    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        out.println("MyServlet service() start ");
        response.getWriter().println("<Br> MyServlet service() Executed " + request.getParameter("name"));
        response.getWriter().println("<Br> MyServlet service() Executed " + request.getAttribute("name"));
        out.println("MyServlet service() end");

    }


}
