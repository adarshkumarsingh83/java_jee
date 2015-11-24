package com.adarsh.listener.session;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import static java.lang.System.out;

/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MySessionListener implements HttpSessionListener {

    static {
        out.println("MySessionListener static block");
    }

    {
        out.println("MySessionListener instance  block");
    }

    public MySessionListener() {
        out.println("MySessionListener constructor");
    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        out.println("MySessionListener  sessionCreated()");
        out.println("HttpSessionEvent source " + event.getSource());
        out.println("HttpSessionEvent sessionObject " + event.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        out.println("MySessionListener  sessionDestroyed()");
        out.println("HttpSessionEvent source " + event.getSource());
        out.println("HttpSessionEvent sessionObject " + event.getSession());
    }

}
