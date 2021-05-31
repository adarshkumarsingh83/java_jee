package com.adarsh.servlet;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns ={ "/myServletMultipleUrl","*.do","/myServlet/myServlet"}
        ,name = "MyServlet"
        ,description = "My Annotation Servlet"
        ,displayName = "MyServlet"
        , loadOnStartup = 1
        , initParams = {
        @WebInitParam(name = "param1", value = "value1"),
        @WebInitParam(name = "param2", value = "value2")
}
)
public class MyServletMultipleUrl extends HttpServlet {


    private static final Logger log = LoggerFactory.getLogger(MyServletMultipleUrl.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.info("MyServlet doGet()");
        doProcess(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.info("MyServlet doPost()");
        doProcess(request,response);
    }

    private void   doProcess(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletConfig servletConfig=super.getServletConfig();
        servletConfig.getInitParameter("param1");
        servletConfig.getInitParameter("param2");
        request.getSession().removeAttribute("filterOneSession");
        request.getSession().removeAttribute("filterTwoSession");
        response.setContentType("text/plain");
        response.getWriter().write(new Date().toString()+" Param1 "+servletConfig.getInitParameter("param1")+"  Param2 "+
        servletConfig.getInitParameter("param2"));
    }

}