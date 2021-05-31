package com.adarsh.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

import static java.lang.System.out;
/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MyFilterFirst implements Filter {

    private transient FilterConfig filterConfig = null;

    static {
        out.println("MyFilterFirst static block ");
    }

    {
        out.println("MyFilterFirst instance block ");
    }

    public MyFilterFirst() {
        out.println("MyFilterFirst constructor ");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        out.println("MyFilterFirst inti()");
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
        out.println("MyFilterFirst destroy()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        Enumeration filterInitParam = filterConfig.getInitParameterNames();
        out.print("Filter Initilization Parameter in 1st Filter");
        while (filterInitParam.hasMoreElements()) {
            String paramName = (String) filterInitParam.nextElement();
            out.println(paramName + " " + filterConfig.getInitParameter(paramName));
        }
        out.println("MyFilterFirst before doFilter() ");
        filterChain.doFilter(servletRequest, servletResponse);
        out.println("MyFilterFirst after doFilter() ");
    }


}
