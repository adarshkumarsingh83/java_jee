package com.adarsh.servlet;

import javax.servlet.ServletException;
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doProcess(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doProcess(req, resp);
    }

    private void doProcess(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        final PrintWriter printWriter = resp.getWriter();
        final Object attributeUserName = req.getParameter("username");
        final Object attributeUserPwd = req.getParameter("password");
        if (attributeUserName != null && attributeUserPwd != null) {
            final String userName = attributeUserName.toString().trim();
            final String userPwd = attributeUserPwd.toString().trim();
            if (userName.equals(userPwd)) {
                printWriter.print("<h1> Welcome to Application </h1>");
            } else {
                printWriter.print("<h1> Invalid Credential </h1>");
            }
        } else {
            printWriter.print("<h1> UserName or UserPwd is Missing </h1>");
        }
    }
}
