package com.adarsh.filter;

import com.adarsh.wrapper.httprequest.MyHttpServletRequestWrapper;
import com.adarsh.wrapper.httpresponse.MyHttpServletResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        out.println("MyFilter doFilter() started ");
        chain.doFilter(new MyHttpServletRequestWrapper((HttpServletRequest) request), new MyHttpServletResponseWrapper((HttpServletResponse) response));
        out.println("MyFilter doFilter() ended ");
    }


    public void destroy() {

    }

}
