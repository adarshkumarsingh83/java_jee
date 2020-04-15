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
        , displayName = "MyServletSecondFilter"
        , description = "Filter for MyServlet 2"
        , filterName = "MyServletSecondFilter"
        , dispatcherTypes = DispatcherType.REQUEST
        , initParams = {
        @WebInitParam(name = "param1", value = "value1"),
        @WebInitParam(name = "param2", value = "value2")}
)
public class MyServletSecondFilter implements Filter {

    Logger log = LoggerFactory.getLogger(MyServletSecondFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyServletSecondFilter init() ");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        log.info("MyServletSecondFilter doFilter() ");
        ((HttpServletRequest)request).getSession().setAttribute("filterTwoSession","filterTwoSession");
        chain.doFilter(request, response);
        if (response instanceof HttpServletResponse) {
            log.info("Applying cache control filter to response");
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.setHeader("Cache-Control", "nocache");
        }
    }

    @Override
    public void destroy() {
        log.info("MyServletSecondFilter destroy() ");
    }

}