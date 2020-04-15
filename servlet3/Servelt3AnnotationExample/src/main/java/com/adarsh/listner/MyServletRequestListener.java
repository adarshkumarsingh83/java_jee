package com.adarsh.listner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletRequestListener implements ServletRequestListener {

    private static final Logger log = LoggerFactory.getLogger(MyServletRequestListener.class);


    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("MyServletRequestListener requestDestroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("MyServletRequestListener requestInitialized");
    }
}
