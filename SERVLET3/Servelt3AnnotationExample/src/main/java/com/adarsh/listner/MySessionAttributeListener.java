package com.adarsh.listner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MySessionAttributeListener implements HttpSessionAttributeListener {

    private static final Logger log = LoggerFactory.getLogger(MySessionAttributeListener.class);


    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        log.info("MySessionListener attributeAdded");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        log.info("MySessionListener attributeRemoved");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        log.info("MySessionListener attributeReplaced");
    }
}
