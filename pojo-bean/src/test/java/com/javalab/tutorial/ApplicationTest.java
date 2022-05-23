package com.javalab.tutorial;

import com.javalab.tutorial.bean.CustomerBean;
import com.javalab.tutorial.pojo.CustomerPojo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ApplicationTest {
    private static Logger LOGGER = LoggerFactory.getLogger(ApplicationTest.class);

    @Test
    void whenCustomerBeanObjectCreated_thenCustomerBeanObjectMustBeCreated() {
        LOGGER.info("ApplicationTest#whenCustomerBeanObjectCreated_thenCustomerBeanObjectMustBeCreated");
        CustomerBean customer = new CustomerBean();
        Assertions.assertThat(customer).isNotNull();
    }

    @Test
    void whenCustomerPojoObjectCreated_thenCustomerPojoObjectMustBeCreated() {
        LOGGER.info("ApplicationTest#whenCustomerPojoObjectCreated_thenCustomerPojoObjectMustBeCreated");
        CustomerPojo customer = new CustomerPojo("Ali", 30);
        Assertions.assertThat(customer).isNotNull();
    }
}