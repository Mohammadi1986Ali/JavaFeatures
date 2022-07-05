package com.javalab.tutorial.suppressed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionalResource implements AutoCloseable {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionalResource.class);

    public void process() {
        LOGGER.info("ExceptionalResource#process");
        throw new IllegalArgumentException("Thrown exception from process()");
    }

    @Override
    public void close() throws Exception {
        LOGGER.info("ExceptionalResource#close");
        throw new NullPointerException("Thrown null pointer exception from close()");
    }
}
