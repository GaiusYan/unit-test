package com.yan.test_unit.customer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
     void shouldReturnAllCustomers() {
//        todo : arrange
        Customer customerOne = new Customer();
        customerOne.setEmail("gaiusyanbena11@gmail.com");
        Customer customerTwo = new Customer();
        customerTwo.setEmail("pierreaxel@gmail.com");
        this.customerRepository.saveAll(List.of(customerOne, customerTwo));

//        todo : act
        final List<Customer> customers = this.customerRepository.findAll();
//        todo : Asserts
        Assertions.assertEquals(2, customers.size());
    }

    @Test
    void shouldReturnCustomerByEmail() {
        //        todo : arrange
        Customer customerOne = new Customer();
        customerOne.setEmail("gaiusyanbena11@gmail.com");
        Customer customerTwo = new Customer();
        customerTwo.setEmail("pierreaxel@gmail.com");
        this.customerRepository.saveAll(List.of(customerOne, customerTwo));

//        todo : act
        final Customer customer = this.customerRepository.findByEmail("pierreaxel@gmail.com");
//        todo : Asserts
        Assertions.assertEquals(4,customer.getId());
        Assertions.assertEquals(customerTwo.getEmail(),customer.getEmail());
    }
}