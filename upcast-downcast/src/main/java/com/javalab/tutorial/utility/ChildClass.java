package com.javalab.tutorial.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChildClass extends ParentClass {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChildClass.class);

    public String childName;

    @Override
    public String getName() {
        LOGGER.info("ChildClass#logName");
        return childName;
    }
}
