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
public class MyServletThree extends HttpServlet {

    static {
        out.println("MyServletThree static block ");
    }

    {
        out.println("MyServletThree instance block ");
    }

    public MyServletThree() {
        out.println("MyServletThree constructor ");
    }

    @Override
    public void init() {
        out.println("MyServletThree init()");
    }


    @Override
    protected void doGet(HttpServletRequest requestObject, HttpServletResponse responseObject)
            throws ServletException, IOException {
        PrintWriter pw = responseObject.getWriter();
        pw.print("<br/>MyServletThree goGET() start ");
        out.println("MyServletThree doGET() start ");

        pw.write("<br/>Hi this is servet three ");
        Enumeration enumeration = requestObject.getAttributeNames();
        while (enumeration.hasMoreElements()) {
            pw.write("<br>Data Added by servelt " + enumeration.nextElement());
        }
        pw.write("Hi this is servet thtee ");

        pw.print("<br/>MyServletThree goGET() end ");
        out.println("MyServletThree doGET() end ");
    }

    @Override
    public void destroy() {
        out.println("MyServletThree destroyed() ");
    }
}
