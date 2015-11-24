package com.adarsh.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author $CreatedBy Adarsh_K
 * @author $LastChangedBy: Adarsh_K
 * @version $Revision: ${File.version} $, $Date:: 27/8/13 11:54 AM
 * @see
 */
public class LoginServlet extends HttpServlet {

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

        final Object userNameObject = req.getParameter("userName");
        final Object userPwdObject = req.getParameter("userPwd");

        if (userNameObject != null && userPwdObject != null) {
            final String userName = userNameObject.toString().trim();
            final String userPwd = userPwdObject.toString().trim();
            final PrintWriter printWriter = resp.getWriter();
            if (userName.equals("adarsh") && userPwd.equals("radha")) {
                printWriter.print("<BR><BR><BR><h1>USER CREDENTIAL ARE CORRECT </h1>");
            } else {
                printWriter.print("<BR><BR><BR><h1>USER CREDENTIAL AREN'T CORRECT </h1>");
            }
        }
    }
}
