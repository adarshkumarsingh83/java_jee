package com.espark.adarsh.filter;

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
)
/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
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
    }

    @Override
    public void destroy() {
        log.info("MyServletFirstFilter destroy() ");
    }

}