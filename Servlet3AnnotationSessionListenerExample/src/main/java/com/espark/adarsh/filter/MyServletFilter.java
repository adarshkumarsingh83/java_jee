package com.espark.adarsh.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(value = "/myServlet"
        , displayName = "MyServletFilter"
        , description = "Filter for MyServlet"
        , filterName = "MyServletFilter"
        , dispatcherTypes = DispatcherType.REQUEST
)
/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
public class MyServletFilter implements Filter {

    Logger log = LoggerFactory.getLogger(MyServletFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyServletFilter init() ");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        log.info("MyServletFilter doFilter() ");
        ((HttpServletRequest)request).getSession().setAttribute("filterSession","filterSessionValue");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("MyServletFilter destroy() ");
    }

}