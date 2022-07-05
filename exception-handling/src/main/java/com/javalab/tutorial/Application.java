package com.javalab.tutorial;

import com.javalab.tutorial.globalexceptionhandler.GlobalExceptionHandler;
import com.javalab.tutorial.globalexceptionhandler.MyHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private final static Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        LOGGER.info("Application#main");
        MyHandler handler = new MyHandler();
        Thread.setDefaultUncaughtExceptionHandler(handler);
        new GlobalExceptionHandler().performArithmeticOperation(10, 0);
    }
}