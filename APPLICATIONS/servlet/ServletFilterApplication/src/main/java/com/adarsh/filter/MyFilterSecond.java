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
public class MyFilterSecond implements Filter {

    private transient FilterConfig filterConfig = null;


    static {
        out.println("MyFilterSecond static block ");
    }

    {
        out.println("MyFilterSecond instance block ");
    }

    public MyFilterSecond() {
        out.println("MyFilterSecond constructor ");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        out.println("MyFilterSecond init()");
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
        out.println("MyFilterSecond destroy()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {


        Enumeration filterInitParam = filterConfig.getInitParameterNames();
        out.print("Filter Initilization Parameter 2nd Filter ");
        while (filterInitParam.hasMoreElements()) {
            String paramName = (String) filterInitParam.nextElement();
            out.println(paramName + " " + filterConfig.getInitParameter(paramName));
        }

        out.println("MyFilterSecond before doFilter() ");
        filterChain.doFilter(servletRequest, servletResponse);
        out.println("MyFilterSecond after doFilter() ");
    }
}
