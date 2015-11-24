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
    private static final String displayPageDatabase = "/WEB-INF/jsp/displayDatabase.jspx";
    private static final String displayPageTable = "/WEB-INF/jsp/displayTable.jspx";
    private static final String displayPageTableList = "/WEB-INF/jsp/displayTableList.jspx";
    private static final String inputPageName = "/WEB-INF/jsp/input.jspx";


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Object page = request.getParameter(pageName);
        if (page != null) {
            RequestDispatcher requestDispatcher = null;
            if (page.toString().equals("input")) {
                requestDispatcher = request.getRequestDispatcher(inputPageName);
                requestDispatcher.forward(request, response);
            } else if (page.toString().endsWith("displayTable")) {
                request.getSession(true).setAttribute("sqlQueryForTableList", "SELECT Table_Schema ,Table_Name  FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE = 'BASE TABLE' And Table_Schema ='"+request.getParameter("dataBaseName")+"'");
                requestDispatcher = request.getRequestDispatcher(displayPageTableList);
                requestDispatcher.forward(request, response);
            }else if(page.toString().equals("tableDescription")){
                request.getSession(true).setAttribute("sqlQueryForTableDescription", "select column_name,column_type,table_name,column_key from INFORMATION_SCHEMA.COLUMNS where table_name ='"+ request.getParameter("tableName")+"'");
                requestDispatcher = request.getRequestDispatcher(displayPageTable);
                requestDispatcher.forward(request, response);
            }
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
            request.getSession(true).setAttribute("userName", userNameObject);
            request.getSession(true).setAttribute("userPwd", userPwdObject);
            request.getSession(true).setAttribute("driverClassName", "com.mysql.jdbc.Driver");
            request.getSession(true).setAttribute("dataBaseUrl", "jdbc:mysql://192.168.0.168:3306/myDatabase");
            request.getSession(true).setAttribute("sqlQueryForDataBaseList", " SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA");


            requestDispatcher = request.getRequestDispatcher(displayPageDatabase);
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

}
