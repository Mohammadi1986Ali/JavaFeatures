package com.javalab.tutorial.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class CustomerBean implements Serializable {

    private static long serialVersionUID = 1613299737795205292L;

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerBean.class);

    private String name;
    private Integer age;

    public CustomerBean() {
        LOGGER.info("CustomerBean#CustomerBean");
    }

    public CustomerBean(String name, Integer age) {
        LOGGER.info("CustomerBean#CustomerBean name: {}, age: {}", name, age);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
