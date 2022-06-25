package com.javalab.tutorial.callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

public class FactorialTask implements Callable<Integer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FactorialTask.class);

    int number;

    public FactorialTask(int number) {
        LOGGER.info("FactorialTask#FactorialTask int: {}", number);
        this.number = number;
    }

    @Override
    public Integer call() throws InvalidParameterException {

        int factorial = 1;
        if (number < 0) {
            throw new InvalidParameterException("Number must be positive");
        }

        for (int count = number; count > 0; count--) {
            factorial *= count;
        }

        return factorial;
    }

    private class InvalidParameterException extends Exception {
        public InvalidParameterException(String message) {
            super(message);
        }
    }

}
