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
    private static final long serialVersionUID = 1L;


    public MyServlet() {
        super();
        out.println("MyServlet constructor");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        out.println("MyServlet doGet() start");

        response.getWriter().println("MyServlet doGet() ");

        getServletConfig().getServletContext().setAttribute("data", "Application scope data");
        request.getSession().setAttribute("Session", "sonu and monu ");
        request.getRequestDispatcher("/myJsp").forward(request, response);

        out.println("MyServlet doGet() end");
    }

}
