package com.adarsh.listener.request;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import static java.lang.System.out;

/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MyServletRequestListnener implements ServletRequestListener {

    static {
        out.println("MyServletRequestListnener static block");
    }

    {
        out.println("MyServletRequestListnener instance block");
    }

    public MyServletRequestListnener() {
        out.println("MyServletRequestListnener constructor");
    }


    @Override
    public void requestInitialized(ServletRequestEvent event) {
        out.println("MyServletRequestListnener requestInitialized");
        out.println("ServletRequest source " + event.getSource());
        out.println("Servlet Context Object " + event.getServletContext() + " ServletResponseObject  " + event.getServletRequest());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        out.println("MyServletRequestListnener requestDestroyed()");
        out.println("ServletRequest source " + event.getSource());
        out.println("Servlet Context Object " + event.getServletContext() + " ServletResponseObject  " + event.getServletRequest());
    }
}
