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
public class MyServlet extends HttpServlet {

    static {
        out.println("MyServlet static block ");
    }

    {
        out.println("MyServlet instance block");
    }

    public MyServlet() {
        out.println("MyServlet constructor ");
    }

    @Override
    public void init() {
        out.println("MyServlet Init() ");
    }


    @Override
    protected void doGet(HttpServletRequest requestObject, HttpServletResponse responseObject)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        PrintWriter pw = responseObject.getWriter();

        Enumeration servletInitParam = getServletConfig().getInitParameterNames();
        while (servletInitParam.hasMoreElements()) {
            String parameterName = (String) servletInitParam.nextElement();
            pw.print("<br/> " + parameterName + " " + getServletConfig().getInitParameter(parameterName));
        }

        Enumeration servletContextParam = getServletConfig().getServletContext().getInitParameterNames();
        while (servletContextParam.hasMoreElements()) {
            String parameterName = (String) servletContextParam.nextElement();
            pw.print("<BR/>" + parameterName + " " + getServletConfig().getServletContext().getInitParameter(parameterName));
        }
    }

    @Override
    public void destroy() {
        out.println("MyServlet destroy()");
    }
}
