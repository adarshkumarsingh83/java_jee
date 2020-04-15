package com.adarsh.genricservlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

import static java.lang.System.out;

/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MyGenericServlet extends GenericServlet {

    static {
        out.println("MyGenericServlet static block ");
    }

    {
        out.println("MyGenericServlet instance block ");
    }

    public MyGenericServlet() {
        out.println("MyGenericServlet constructor");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {
        out.println("MyGenericServlet service()");
        servletRequest.setAttribute("msg", "Hello  " + servletRequest.getParameter("userName"));
        servletRequest.getRequestDispatcher("/myJsp").forward(servletRequest, servletResponse);
    }

}
