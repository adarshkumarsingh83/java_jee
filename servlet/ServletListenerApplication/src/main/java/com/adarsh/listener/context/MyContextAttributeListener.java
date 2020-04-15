package com.adarsh.listener.context;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

import static java.lang.System.out;

/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MyContextAttributeListener implements
        ServletContextAttributeListener {

    static {
        out.println("MyContextAttributeListener static block ");
    }

    {
        out.println("MyContextAttributeListener instacne block ");
    }

    public MyContextAttributeListener() {
        out.println("MyContextAttributeListener constructor");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        out.println("MyContextAttributeListener attributeAdded()");
        out.println("Event name " + event.getName() + " Event Source" + event.getSource());
        out.println("Servletcontext Object " + event.getServletContext() + " ContextAtribute Event " + event.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        out.println("MyContextAttributeListener attributeRemoved()");
        out.println("Event name " + event.getName() + " Event Source" + event.getSource());
        out.println("Servletcontext Object " + event.getServletContext() + " ContextAtribute Event " + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        out.println("MyContextAttributeListener attributeReplaced()");
        out.println("Event name " + event.getName() + " Event Source" + event.getSource());
        out.println("Servletcontext Object " + event.getServletContext() + " ContextAtribute Event " + event.getValue());

    }

}
