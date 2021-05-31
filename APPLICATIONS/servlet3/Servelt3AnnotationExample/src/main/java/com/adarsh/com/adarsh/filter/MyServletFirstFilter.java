package com.adarsh.com.adarsh.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = "/myServlet"
        , displayName = "MyServletFirstFilter"
        , description = "Filter for MyServlet"
        , filterName = "MyServletFirstFilter"
        , dispatcherTypes = DispatcherType.REQUEST
        , initParams = {
        @WebInitParam(name = "param1", value = "value1"),
        @WebInitParam(name = "param2", value = "value2")}
)
public class MyServletFirstFilter implements Filter {

    Logger log = LoggerFactory.getLogger(MyServletFirstFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyServletFirstFilter init() ");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        log.info("MyServletFirstFilter doFilter() ");
        ((HttpServletRequest)request).getSession().setAttribute("filterOneSession","filterOneSessionValue");
        chain.doFilter(request, response);
        if (response instanceof HttpServletResponse) {
            log.info("Applying cache control filter to response");
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.setHeader("Cache-Control", "nocache");
        }
    }

    @Override
    public void destroy() {
        log.info("MyServletFirstFilter destroy() ");
    }

}