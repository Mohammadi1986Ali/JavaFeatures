package com.javalab.tutorial.globalexceptionhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobalExceptionHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public int performArithmeticOperation(int number_1, int number_2) {
        LOGGER.info("GlobalExceptionHandler#performArithmeticOperation");
        return number_1/number_2;
    }
}
