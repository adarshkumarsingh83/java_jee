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
public class MyServletTwo extends HttpServlet {

    static {
        out.println("MyServletTwo static block ");
    }

    {
        out.println("MyServletTwo instance block ");
    }

    public MyServletTwo() {
        out.println("MyServletTwo constructor ");
    }

    @Override
    public void init() {
        out.println("MyServletTwo init()");
    }


    @Override
    protected void doGet(HttpServletRequest requestObject, HttpServletResponse responseObject)
            throws ServletException, IOException {
        PrintWriter pw = responseObject.getWriter();
        pw.print("<br/>MyServletTwo goGET() start ");
        out.println("MyServletTwo doGET() start ");

        pw.write("<br/>Hi this is servet two ");
        Enumeration enumeration = requestObject.getAttributeNames();
        while (enumeration.hasMoreElements()) {
            pw.write("<br>Data Added by servelt " + enumeration.nextElement());
        }
        pw.write("Hi this is servet two ");

        pw.print("<br/>MyServletTwo goGET() end ");
        out.println("MyServletTwo doGET() end ");
    }

    @Override
    public void destroy() {
        out.println("MyServletTwo destroyed() ");
    }
}
