package com.adarsh.servlet;

import org.apache.commons.lang.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/

public class MyServlet extends HttpServlet {

    private static final String pageName = "pageName";
    private static final String displayPageName = "/WEB-INF/jsp/displayPage.jspx";
    private static final String  inputPageName= "/WEB-INF/jsp/input.jspx";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Object page = request.getParameter(pageName);
        if (page != null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(inputPageName);
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
                && (!StringUtils.isEmpty(userPwdObject.toString().trim()))) {

            request.setAttribute("userSet", getUser());
            requestDispatcher = request.getRequestDispatcher(displayPageName);
            requestDispatcher.forward(request, response);
        } else {
            request.setAttribute("msgUserName", (userNameObject == null
                    || (StringUtils.isEmpty(userNameObject.toString().trim()))) ? "User Name is Empty" : null);
            request.setAttribute("msgUserPwd", (userPwdObject == null
                    || (StringUtils.isEmpty(userPwdObject.toString().trim()))) ? "User Pwd is Empty" : null);
            requestDispatcher = request.getRequestDispatcher(inputPageName);
            requestDispatcher.forward(request, response);
        }
    }

    private Set<User> getUser() {
        Set<User> userSet=new HashSet<User>();
        for (int i = 0; i < 10; i++) {
            userSet.add(new User("userName" + i, "userPwd" + i));
        }
        return userSet;
    }
}
