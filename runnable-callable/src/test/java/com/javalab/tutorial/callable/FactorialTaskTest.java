package com.javalab.tutorial.callable;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FactorialTaskTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FactorialTask.class);
    private ExecutorService executorService;

    @BeforeEach
    public void setup() {
        LOGGER.info("Setting test environment");
        executorService = Executors.newSingleThreadExecutor();
    }

    @Test
    public void givenPositiveNumber_whenTaskSubmitted_thenFutureResultObtained() throws ExecutionException, InterruptedException {
        LOGGER.info("FactorialTaskTest#givePositiveNumber_whenTaskSubmitted_thenFutureResultObtained");
        FactorialTask task = new FactorialTask(4);
        Future<Integer> future = executorService.submit(task);
        assertEquals(24, future.get().intValue());
    }

    @Test
    public void givenNegativeNumber_whenGetIsCalled_thenCallableThrowsException() {
        LOGGER.info("FactorialTaskTest#giveNegativeNumber_whenGetIsCalled_thenCallableThrowsException");
        FactorialTask task = new FactorialTask(-5);
        Future<Integer> future = executorService.submit(task);

        Exception exception = null;

        try {
            future.get().intValue();
        } catch (InterruptedException e) {
            exception = e;
        } catch (ExecutionException e) {
            exception = e;
        }

        assertTrue(exception.getMessage().contains("Number must be positive"));
    }

    @Test
    public void givenNegativeNumber_whenGetIsNotCalled_thenCallableDoesntThrowsException() {
        LOGGER.info("FactorialTaskTest#giveNegativeNumber_whenGetIsNotCalled_thenCallableDoesntThrowsException");
        FactorialTask task = new FactorialTask(-5);
        Future<Integer> future = executorService.submit(task);
        assertEquals(false, future.isDone());
    }

    @AfterEach
    public void cleanup() {
        LOGGER.info("Cleaning test environment");
        executorService.shutdown();
    }

}