package com.adarsh.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
        out.println("MyServlet instance block ");
    }

    public MyServlet() {
        out.println("MyServlet Constructor ");
    }

    @Override
    public void init() {
        out.println("MyServlet init()");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        out.println("MyServlet doGet() start");
        out.println("Servlet Context Atribute");

        /*putting data into http session object */
        HttpSession sessionObject = req.getSession();
        sessionObject.setAttribute("adarsh ", "radha ");

        /*putting data into servelt context object */
        ServletContext servletContext = getServletConfig().getServletContext();
        servletContext.setAttribute("adarsh ", "radha");
        servletContext.removeAttribute("adarsh");

        /*putting data into response object */
        req.setAttribute("adarsh", "radha");
        req.removeAttribute("adarsh");

        resp.getWriter().println(" this is form MyServlet ");

        out.println("MyServlet doGet() end");
    }

    @Override
    public void destroy() {
        out.println("MyServlet destroy()");
    }

}
