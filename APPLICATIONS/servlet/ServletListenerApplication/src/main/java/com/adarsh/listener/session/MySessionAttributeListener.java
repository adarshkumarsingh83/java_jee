package com.adarsh.listener.session;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import static java.lang.System.out;

/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MySessionAttributeListener implements HttpSessionAttributeListener {

    static {
        out.println("MySessionAttributeListener static block ");
    }

    {
        out.println("MySessionAttributeListener instacne block ");
    }

    public MySessionAttributeListener() {
        out.println("MySessionAttributeListener constructor");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        out.println("MySessionAttributeListener attributeAdded()");
        out.println("Event Name " + event.getName() + " Event source " + event.getSource());
        out.println("SessionObject " + event.getSession() + "Event Object " + event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        out.println("MySessionAttributeListener attributeRemoved()");
        out.println("Event Name " + event.getName() + " Event source " + event.getSource());
        out.println("SessionObject " + event.getSession() + "Event Object " + event.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        out.println("MySessionAttributeListener attributeReplaced()");
        out.println("Event Name " + event.getName() + " Event source " + event.getSource());
        out.println("SessionObject " + event.getSession() + "Event Object " + event.getValue());
    }

}
