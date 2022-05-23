package com.javalab.tutorial.runnable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogHandler implements Runnable{
    private static Logger LOGGER = LoggerFactory.getLogger(LogHandler.class);

    private String message;

    public LogHandler(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        LOGGER.info(message);
    }
}
