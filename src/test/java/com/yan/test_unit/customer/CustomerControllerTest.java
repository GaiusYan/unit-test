package com.yan.test_unit.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HttpCodeStatusMapper;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {
    @Autowired
    MockMvc mvc;
    @Autowired
    private HttpCodeStatusMapper healthHttpCodeStatusMapper;

    @Test
    void shouldReturnListOfCustomers() throws Exception {
        this.mvc.perform(get("/customers"))
                .andExpect(healthHttpCodeStatusMapper().isOk())
    }
}