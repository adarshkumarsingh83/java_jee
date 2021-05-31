package com.adarsh.web.servlet;

import com.adarsh.web.util.WebUtil;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ashish
 * @author $LastChangedBy: Ashish $
 * @version $Revision: 1595 $, $Date:: 9/23/12 9:54 PM#$
 */
public class ApplicationController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(ApplicationController.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        new WebUtil().findManager(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        new WebUtil().findManager(req, resp);
    }
}
