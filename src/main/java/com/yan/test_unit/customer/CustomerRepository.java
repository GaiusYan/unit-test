package com.yan.test_unit.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CustomerRepository
        extends JpaRepository<Customer,Long> {

    Customer findByEmail(String email);
}
