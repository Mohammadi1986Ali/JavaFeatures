package com.javalab.tutorial.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerPojo {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerPojo.class);

    public String name;
    public Integer age;

    public CustomerPojo(String name, Integer age) {

        LOGGER.info("CustomerPojo#CustomerPojo name: {}, age: {}", name, age);

        this.name = name;
        this.age = age;
    }
}
