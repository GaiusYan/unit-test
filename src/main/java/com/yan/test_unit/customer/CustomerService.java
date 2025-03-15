package com.yan.test_unit.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    CustomerRepository customerRepository;

    public List<CustomerDTO> search() {
         return this.customerRepository
                 .findAll()
                 .stream()
                 .map(customer -> new CustomerDTO(customer.getId(), customer.getEmail()))
                 .collect(Collectors.toList());
    }

    public CustomerDTO read(Long id) {
        Customer customer =  this.customerRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Customer not found"));
        return new CustomerDTO(customer.getId(), customer.getEmail());
    }
}
