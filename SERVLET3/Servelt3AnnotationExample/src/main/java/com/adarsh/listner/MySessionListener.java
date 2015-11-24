package com.adarsh.listner;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class MySessionListener implements HttpSessionListener {

    private static final Logger log = LoggerFactory.getLogger(MySessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        log.info("MySessionListener Session created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        log.info("MySessionListener Session destroyed");
    }

}
