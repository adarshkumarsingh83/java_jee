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
        out.println("MyServlet static block");
    }

    {
        out.println("MyServlet instance block");
    }

    public MyServlet() {
        out.println("MyServlet constructor");
    }

    @Override
    public void init() {
        out.println("MyServlet init()");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        Enumeration headerName = req.getHeaderNames();
        pw.println("<br/>Header Information");
        while (headerName.hasMoreElements()) {
            String name = (String) headerName.nextElement();
            pw.println("<br/>Header Name " + name + " Header Value " + req.getHeader(name));
        }

        pw.println("<br/>Character Encodeing " + req.getCharacterEncoding());
        pw.println("<br/>ContentLength " + req.getContentLength());
        pw.println("<br/>ContentType " + req.getContentType());
        pw.println("<br/>ContextPath " + req.getContextPath());
        pw.println("<br/>LocalAddr " + req.getLocalAddr());
        pw.println("<br/>LocalName " + req.getLocalName());
        pw.println("<br/>LocalPort " + req.getLocalPort());
        pw.println("<br/>Method " + req.getMethod());
        pw.println("<br/>PathInfo " + req.getPathInfo());
        pw.println("<br/>PathTranslated " + req.getPathTranslated());
        pw.println("<br/>Protocol " + req.getProtocol());
        pw.println("<br/>QueryString " + req.getQueryString());
        pw.println("<br/>RemoteAddr " + req.getRemoteAddr());
        pw.println("<br/>RemoteHost " + req.getRemoteHost());
        pw.println("<br/>RemotePort " + req.getRemotePort());
        pw.println("<br/>RemoteUser " + req.getRemoteUser());
        pw.println("<br/>RequestedSessionId " + req.getRequestedSessionId());
        pw.println("<br/>RequestURI " + req.getRequestURI());
        pw.println("<br/>Scheme " + req.getScheme());
        pw.println("<br/>ServerName " + req.getServerName());
        pw.println("<br/>ServerPort " + req.getServerPort());
        pw.println("<br/>ServletPath " + req.getServletPath());

    }

    @Override
    public void destroy() {
        out.println("MyServlet destroy()");
    }

}
