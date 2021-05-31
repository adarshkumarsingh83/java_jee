package com.adarsh.listener.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import static java.lang.System.out;

/*
* @author Adarsh
* @author $LastChangedBy: adarsh $
* @version $Revision: 1595 $, $Date:: 5/4/12 6:12 PM#$
*/
public class MyContextListener implements ServletContextListener {

    static {
        out.println("MyContextListener static block ");
    }

    {
        out.println("MyContextListener instance block ");
    }

    public MyContextListener() {
        out.println("MyContextListener constructor ");
    }


    @Override
    public void contextInitialized(ServletContextEvent event) {
        out.println("MyContextListener contextInitialized()");
        out.println("context Event Source " + event.getSource() + "ServletContextObject " + event.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        out.println("MyContextListener contextDestroyed()");
        out.println("context Event Source " + event.getSource() + "ServletContextObject " + event.getServletContext());
    }


}
