package com.adarsh.web.util;

import com.adarsh.web.manager.LoginManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ashish
 * @author $LastChangedBy: Ashish $
 * @version $Revision: 1595 $, $Date:: 9/23/12 9:54 PM#$
 */
public class WebUtil {

    private static final Logger LOGGER = Logger.getLogger(WebUtil.class);
    private static WebUtil webUtil = null;
    private static Map<String, Class> managerClassMap = new HashMap<String, Class>() {
        {
            put("login", LoginManager.class);
        }
    };

    static {
        webUtil = new WebUtil();
    }

    private String actualUrl = null;
    private String requestedUrl = null;
    private String contextPath = null;
    private String viewDirectory = "/WEB-INF/view";

    public void findManager(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String pageUrl = processUrl(req, resp);
        if (req.getMethod().equalsIgnoreCase("GET")) {
            sendToResource(pageUrl, req, resp);
        } else {

            if (!new LoginManager().checkLogin(req, resp)) {
                sendToResource("/login.jsp", req, resp);
            } else {
                webUtil.sendToResource(pageUrl, req, resp);
            }
        }
    }

    public String processUrl(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String pageUrl = null;
        actualUrl = req.getRequestURL().toString();
        actualUrl = actualUrl.replaceAll("do", "jsp");
        contextPath = req.getContextPath();
        requestedUrl = actualUrl.substring(actualUrl.indexOf(contextPath), actualUrl.length());
        pageUrl = requestedUrl.substring(contextPath.length(), requestedUrl.length());
        LOGGER.info("Requested Url " + requestedUrl);
        LOGGER.info(" Page Url " + pageUrl);
        /* sendToResource(pageUrl, req, resp);*/
        return pageUrl;
    }

    public void sendToResource(String pageUrl, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(viewDirectory + pageUrl);
        requestDispatcher.forward(req, resp);
    }

    public static WebUtil getWebUtil() {
        return webUtil;
    }
}
