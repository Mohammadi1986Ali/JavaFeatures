package com.javalab.tutorial.globalexceptionhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyHandler implements Thread.UncaughtExceptionHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(MyHandler.class);

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        LOGGER.info("MyHandler#uncaughtException");
        LOGGER.info("Unhandled exception caught!");
    }
}
