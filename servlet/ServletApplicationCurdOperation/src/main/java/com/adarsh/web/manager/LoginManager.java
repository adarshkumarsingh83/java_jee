package com.adarsh.web.manager;

import com.adarsh.web.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ashish
 * @author $LastChangedBy: Ashish $
 * @version $Revision: 1595 $, $Date:: 9/23/12 9:54 PM#$
 */
public class LoginManager {

    protected final static WebUtil webUtil = WebUtil.getWebUtil();


    public boolean checkLogin(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        boolean result = false;
        Object userNameObject = req.getParameter("userName");
        Object userPwdObject = req.getParameter("userPwd");


        if (userNameObject != null && userPwdObject != null) {
            String userName = userNameObject.toString().trim();
            String userPwd = userPwdObject.toString().trim();
            if (userName.length() > 0 && userPwd.length() > 0) {
                if (checkUser(userName, userPwd)) {
                    result = true;
                } else {
                    req.setAttribute("error", "Invalid Credential");
                    result = false;
                }
            } else {
                req.setAttribute("error", "Enter Proper Data ");
                result = false;
            }
        } else {
            result = false;
        }

        return result;
    }

    protected boolean checkUser(String userName, String userPwd) {
        if (userName.equals(userPwd))
            return true;
        else
            return false;
    }
}
