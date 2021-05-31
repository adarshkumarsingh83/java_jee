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
        Object firstNumber = request.getParameter("firstNumber");
        Object secondNumber = request.getParameter("secondNumber");
        if (firstNumber != null && secondNumber != null
                && (!StringUtils.isEmpty(firstNumber.toString().trim()))
                && (!StringUtils.isEmpty(secondNumber.toString().trim()))) {

             request.setAttribute("firstNumber",firstNumber);
             request.setAttribute("secondNumber",secondNumber);
            requestDispatcher = request.getRequestDispatcher(displayPageName);
            requestDispatcher.forward(request, response);
        } else {
            request.setAttribute("firstNumber", (firstNumber == null
                    || (StringUtils.isEmpty(firstNumber.toString().trim()))) ? "First Number is Empty" : null);
            request.setAttribute("secondNumber", (secondNumber == null
                    || (StringUtils.isEmpty(secondNumber.toString().trim()))) ? "Second Number is Empty" : null);
            requestDispatcher = request.getRequestDispatcher(inputPageName);
            requestDispatcher.forward(request, response);
        }
    }

}
