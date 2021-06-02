package com.adarsh.myfilter;

import com.adarsh.wrapper.request.MyRequestWrapper;
import com.adarsh.wrapper.response.MyResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

import static java.lang.System.out;

/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MyFilter implements Filter {

    static {
        out.println("MyFilter static block");
    }

    {
        out.println("MyFilter instance block");
    }

    public MyFilter() {
        out.println("MyFilter constructor");
    }

    public void init(FilterConfig fConfig) throws ServletException {
        out.println("MyFilter init()");
    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        out.println("MyFilter doFilter() started");
        chain.doFilter(new MyRequestWrapper(request), new MyResponseWrapper(response));
        out.println("MyFilter doFilter() started");
    }

    public void destroy() {
        out.println("MyFilter destroy()");
    }
}
