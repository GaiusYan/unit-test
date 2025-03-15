package com.yan.test_unit.customer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
@JdbcTest
@AutoConfigureTestDatabase(
        connection = EmbeddedDatabaseConnection.H2)
class CustomerServiceTest {

    @Autowired
    JdbcTemplate jdbcTemplate;
    CustomerDao customerDao;
    @Test
    void shouldReturnListOfCustomers() {
        // todo : Arrange / Given
         customerDao  = new CustomerDao(jdbcTemplate);
        // todo : Act / when
        List<Customer> customers = this.customerDao.search();
        // todo : Assert / then
        Assertions.assertEquals(3,customers.size());
        Assertions.assertEquals(customers.get(0).getEmail(),"gaiusyanbena11@gmail.com");
    }
}