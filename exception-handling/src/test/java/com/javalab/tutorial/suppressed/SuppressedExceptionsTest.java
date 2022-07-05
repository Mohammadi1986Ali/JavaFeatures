package com.javalab.tutorial.suppressed;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;

class SuppressedExceptionsTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(SuppressedExceptionsTest.class);


    @Test
    public void givenNonExistentFileName_whenAttemptFileOpen_thenNullPointerException() throws IOException {

        LOGGER.info("SuppressedExceptionsTest#givenNonExistentFileName_whenAttemptFileOpen_thenNullPointerException");
        Assertions.assertThatThrownBy(() ->
                SuppressedExceptions.fileNotExist("/non-existent-path/non-existent-file.txt")
        ).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void givenNonExistentFileName_whenAttemptFileOpenStoreSuppressed_thenSuppressedExceptionAvailable() {
        try {
            SuppressedExceptions.addSuppressedException("/non-existent-path/non-existent-file.txt");
        } catch (Exception e) {
            Assertions.assertThat(e).isInstanceOf(NullPointerException.class);
            Assertions.assertThat(e.getSuppressed().length).isEqualTo(1);
            Assertions.assertThat(e.getSuppressed()[0]).isInstanceOf(FileNotFoundException.class);
        }
    }

    @Test
    public void whenUsingExceptionalResource_thenSuppressedExceptionAvailable() {
        try {
            SuppressedExceptions.exceptionalResource();
        } catch (Exception e) {
            Assertions.assertThat(e).isInstanceOf(IllegalArgumentException.class);
            Assertions.assertThat(e.getMessage()).isEqualTo("Thrown exception from process()");
            Assertions.assertThat(e.getSuppressed().length).isEqualTo(1);
            Assertions.assertThat(e.getSuppressed()[0]).isInstanceOf(NullPointerException.class);
            Assertions.assertThat(e.getSuppressed()[0].getMessage()).isEqualTo("Thrown null pointer exception from close()");
        }
    }
}