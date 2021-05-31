package com.adarsh.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;
/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MyServletOne extends HttpServlet {

    static {
        out.print("MyServletOne static block ");
    }

    {
        out.print("MyServletOne instance block ");
    }

    public MyServletOne() {
        out.print("MyServletOne constructor ");
    }

    @Override
    public void init() {
        out.print("MyServletOne init() ");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("<br/>MyServletOne doGet() start ");
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("session 1", "adarsh kumar singh");
        httpSession.setAttribute("session 2", "amritesh kumar singh");
        httpSession.setAttribute("session 3", "amit kumar singh");
        httpSession.setAttribute("session 4", "radha  singh");
        request.getRequestDispatcher("/myServlet2").include(request, response);
        pw.println("<br/>MyServletOne doGet() end ");
    }

    @Override
    public void destroy() {
        out.print("MyServletOne destroy ");
    }
}
