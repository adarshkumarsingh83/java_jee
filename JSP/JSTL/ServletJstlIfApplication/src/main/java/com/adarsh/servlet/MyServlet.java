package com.adarsh.servlet;

import org.apache.commons.lang.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/

public class MyServlet extends HttpServlet {

    private static final String pageName = "pageName";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Object page = request.getParameter(pageName);
        if (page != null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/input.jspx");
            requestDispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = null;
        Object userNameObject = request.getParameter("userName");
        Object userPwdObject = request.getParameter("userPwd");
        if (userNameObject != null && userPwdObject != null
                && (!StringUtils.isEmpty(userNameObject.toString().trim()))
                &&(!StringUtils.isEmpty(userPwdObject.toString().trim()))) {
            request.setAttribute("user", new User(userNameObject.toString(), userPwdObject.toString()));
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/displayPage.jspx");
            requestDispatcher.forward(request, response);
        } else {
            request.setAttribute("msg", "User Name or User Pwd Empty");
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/input.jspx");
            requestDispatcher.forward(request, response);
        }
    }
}
