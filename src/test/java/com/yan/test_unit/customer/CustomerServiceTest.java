package com.yan.test_unit.customer;

import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

//@JdbcTest
@DataJpaTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureTestDatabase(
        connection = EmbeddedDatabaseConnection.H2)
class CustomerServiceTest {

//    @Autowired
//    JdbcTemplate jdbcTemplate;
//    CustomerDao customerDao;

    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    CustomerService customerService;

//    @Test
//    void shouldReturnListOfCustomers() {
//        // todo : Arrange / Given
//         customerDao  = new CustomerDao(jdbcTemplate);
//        // todo : Act / when
//        List<Customer> customers = this.customerDao.search();
//        // todo : Assert / then
//        Assertions.assertEquals(3,customers.size());
//        Assertions.assertEquals(customers.get(0).getEmail(),"gaiusyanbena11@gmail.com");
//    }

    @Test
    void shouldReturnAllCustomers() {
        Customer customerOne = new Customer();
        customerOne.setEmail("gaiusyanbena11@gmail.com");
        Customer customerTwo = new Customer();
        customerTwo.setEmail("pierreaxel@gmail.com");
        when(this.customerRepository.findAll()).thenReturn(List.of(customerOne, customerTwo));

//        todo : act
        final List<CustomerDTO> customersDTOList = this.customerService.search();
//        todo : Asserts
        Assertions.assertEquals(2, customersDTOList.size());
    }


    @Test
    void shouldReturnCustomerById() {
//        todo : arrange
        Customer customerOne = new Customer();
        customerOne.setEmail("gaiusyanbena11@gmail.com");
        when(this.customerRepository.findById(1L)).thenReturn(Optional.of(customerOne));
//        todo : act
        final CustomerDTO customersDTO = this.customerService.read(1L);
//        todo : Asserts
        Assertions.assertEquals(customerOne.getId(), customersDTO.getId());
    }

    @Test
    void shouldThrowException() {
//        todo : Arrange
        when(this.customerRepository.findById(anyLong())).thenReturn(Optional.empty());

        final IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {this.customerService.read(1L);
        });

        assertEquals("Customer not found",exception.getMessage());

    }
}