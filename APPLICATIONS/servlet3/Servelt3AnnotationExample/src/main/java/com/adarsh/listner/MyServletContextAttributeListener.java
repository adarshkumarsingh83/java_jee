package com.adarsh.listner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextAttributeListener implements ServletContextAttributeListener {


    private static final Logger log = LoggerFactory.getLogger(MyServletContextAttributeListener.class);


    @Override
    public void attributeAdded(ServletContextAttributeEvent scab) {
        log.info("MyServletContextAttributeListener attributeAdded");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scab) {
        log.info("MyServletContextAttributeListener attributeRemoved");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scab) {
        log.info("MyServletContextAttributeListener attributeReplaced");
    }


}
