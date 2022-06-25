package com.javalab.tutorial.runnable;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class LogHandlerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogHandler.class);
    private static ExecutorService EXECUTOR;

    @BeforeAll
    public static void setup() {
        LOGGER.info("Setting test environment");
        EXECUTOR = Executors.newCachedThreadPool();
    }

    @Test
    public void givenARunnable_whenRunIt_thenResult() throws Exception {
        LOGGER.info("LogHandlerTest#givenARunnable_whenRunIt_thenResult");
        Thread thread = new Thread(new LogHandler("LogHandler is running by using thread"));
        thread.start();
        thread.join();
    }

    @Test
    public void givenARunnable_whenSubmitToES_thenResult() throws Exception {
        LOGGER.info("LogHandlerTest#givenARunnable_whenSubmitToES_thenResult");
        EXECUTOR.submit(new LogHandler("LogHandler is running by using executor")).get();
    }

    @Test
    public void givenARunnableLambda_whenSubmitToES_thenResult() throws Exception{
        LOGGER.info("LogHandlerTest#givenARunnableLambda_whenSubmitToES_thenResult");
        EXECUTOR.submit(() -> LOGGER.info("Lambda is running by using executor")).get();
    }

    @AfterAll
    public static void cleanup() {
        LOGGER.info("Cleaning test environment");
        EXECUTOR.shutdown();
    }
}