package com.adarsh.listener.request;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

import static java.lang.System.out;
/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MyServletRequestAttributeListener implements
        ServletRequestAttributeListener {

    static {
        out.println("MyServletRequestAttributeListener static block ");
    }

    {
        out.println("MyServletRequestAttributeListener instance block");
    }

    public MyServletRequestAttributeListener() {
        out.println("MyServletRequestAttributeListener constructor ");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent event) {

        out.println("MyServletRequestAttributeListener attributeAdded()");
        out.println("Event Name " + event.getName() + "Event Source " + event.getSource());
        out.println("Servlet Context Object " + event.getServletContext() + "ServletRequestobject " + event.getServletRequest());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent event) {

        out.println("MyServletRequestAttributeListener attributeRemoved()");
        out.println("Event Name " + event.getName() + "Event Source " + event.getSource());
        out.println("Servlet Context Object " + event.getServletContext() + "ServletRequestobject " + event.getServletRequest());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent event) {

        out.println("MyServletRequestAttributeListener attributeReplaced()");
        out.println("Event Name " + event.getName() + "Event Source " + event.getSource());
        out.println("Servlet Context Object " + event.getServletContext() + "ServletRequestobject " + event.getServletRequest());
    }

}
