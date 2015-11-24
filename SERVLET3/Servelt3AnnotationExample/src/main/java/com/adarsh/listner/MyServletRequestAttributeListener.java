package com.adarsh.listner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {

    private static final Logger log = LoggerFactory.getLogger(MyServletRequestAttributeListener.class);


    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        log.info("MyServletRequestAttributeListener attributeAdded");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        log.info("MyServletRequestAttributeListener attributeRemoved");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        log.info("MyServletRequestAttributeListener attributeReplaced");
    }
}
