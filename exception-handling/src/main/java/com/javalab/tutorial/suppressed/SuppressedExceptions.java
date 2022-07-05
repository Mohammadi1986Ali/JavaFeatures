package com.javalab.tutorial.suppressed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SuppressedExceptions {

    private final static Logger LOGGER = LoggerFactory.getLogger(SuppressedExceptions.class);

    public static void fileNotExist(String filePath) throws IOException {
        LOGGER.info("SuppressedExceptions#fileNotExist");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new IOException(e);
        } finally {
            fis.close();
        }
    }

    public static void addSuppressedException(String filePath) throws IOException {
        LOGGER.info("SuppressedExceptions#addSuppressedException");
        Throwable throwable = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
        } catch (IOException e) {
            throwable = e;
        } finally {
            try {
                fis.close();
            } catch (NullPointerException npe) {
                if (throwable != null) {
                    npe.addSuppressed(throwable);
                }
                throw npe;
            }
        }
    }

    public static void exceptionalResource() throws Exception {
        LOGGER.info("SuppressedExceptions#exceptionalResource");
        try (ExceptionalResource exceptionalResource = new ExceptionalResource()) {
            exceptionalResource.process();
        }
    }
}
