package com.adarsh.wrapper.request;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import static java.lang.System.out;

/*
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
 */
public class MyRequestWrapper extends HttpServletRequestWrapper {

    static {
        out.println("MyRequestWrapper static block ");
    }

    {
        out.println("MyRequestWrapper instance block ");
    }

    public MyRequestWrapper(ServletRequest request) {
        super((HttpServletRequest) request);
        out.println("MyRequestWrapper constructor ");
    }

    @Override
    public Object getAttribute(String name) {
        out.println("MyRequestWrapper getAttribute() ");
        super.setAttribute("name", "radha");
        return super.getAttribute(name);
    }

    @Override
    public String getParameter(String name) {
        out.println("MyRequestWrapper getParameter() ");
        return super.getParameter(name);
    }
}
