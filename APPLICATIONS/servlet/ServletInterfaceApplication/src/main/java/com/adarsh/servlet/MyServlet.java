package com.adarsh.servlet;

import javax.servlet.*;
import java.io.IOException;

import static java.lang.System.out;

/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MyServlet implements Servlet {
    private static final long serialVersionUID = 1L;
    protected ServletConfig servletConfig;

    public MyServlet() {
        super();
        out.println("MyServlet constructor");
    }


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {

        out.println("MyServlet doGet() start");
        servletRequest.setAttribute("msg", "Hello  " + servletRequest.getParameter("userName"));
        servletRequest.getRequestDispatcher("/myJsp").forward(servletRequest, servletResponse);
        out.println("MyServlet doGet() end");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
