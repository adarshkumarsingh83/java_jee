package com.adarsh.listner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MySessionBindingListener implements HttpSessionBindingListener {

    private static final Logger log = LoggerFactory.getLogger(MySessionBindingListener.class);


    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        log.info("MySessionBindingListener valueBound");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        log.info("MySessionBindingListener valueUnbound");
    }
}
