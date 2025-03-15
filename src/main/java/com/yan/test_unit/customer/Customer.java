package com.yan.test_unit.customer;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "customer")
@Builder
public class Customer {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String email;

    public Customer() {
    }

    public Customer(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
