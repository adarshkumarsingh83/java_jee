package com.adarsh.listner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MySessionActivationListener implements HttpSessionActivationListener {

    private static final Logger log = LoggerFactory.getLogger(MySessionActivationListener.class);


    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        log.info("MySessionActivationListener sessionWillPassivate");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        log.info("MySessionActivationListener sessionDidActivate");
    }
}
