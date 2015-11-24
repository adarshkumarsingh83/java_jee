package com.adarsh.wrapper.httprequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import static java.lang.System.out;
/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MyHttpServletRequestWrapper extends HttpServletRequestWrapper {

    static {
        out.println("MyHttpServletRequestWrapper static block");
    }

    {
        out.println("MyHttpServletRequestWrapper instance block");
    }

    public MyHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        out.println("MyHttpServletRequestWrapper constructor");
    }

    @Override
    public Object getAttribute(String name) {
        out.println("MyHttpServletRequestWrapper getAttribute()");
        super.setAttribute("name", "radha");
        return super.getAttribute(name);
    }

    @Override
    public String getParameter(String name) {
        out.println("MyHttpServletRequestWrapper getParameter()");
        return super.getParameter(name);
    }

}
