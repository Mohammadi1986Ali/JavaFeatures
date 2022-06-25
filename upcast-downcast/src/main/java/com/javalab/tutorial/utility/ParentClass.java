package com.javalab.tutorial.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParentClass {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParentClass.class);

    public String parentName;

    public String getName() {
        LOGGER.info("ParentClass#logName");
        return parentName;
    }
}
