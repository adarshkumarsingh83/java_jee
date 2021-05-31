package com.adarsh.servlet;

import org.apache.tomcat.util.buf.Base64;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MyServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("This is the Test Servlet");

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();
            out.print("<br/>Header Name: <em>" + headerName);
            String headerValue = request.getHeader(headerName);
            out.print("</em>, Header Value: <em>" + headerValue);
            out.println("</em>");
        }

        out.println("<hr/>");
        String authHeader = request.getHeader("authorization");
        String encodedValue = authHeader.split(" ")[1];
        out.println("Base64-encoded Authorization Value: <em>" + encodedValue);
        String decodedValue = Base64.base64Decode(encodedValue);
        out.println("</em><br/>Base64-decoded Authorization Value: <em>" + decodedValue);
        out.println("</em>");
    }

}