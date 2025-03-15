package com.yan.test_unit.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao {
    private final JdbcTemplate jdbcTemplate;
    private final static String FIND_ALL = "select * from customer";

    public CustomerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Customer> customerRowMapper =
            (rs, rowNum) -> new Customer(
                    rs.getLong("id"),
                    rs.getString("email"));

    public List<Customer> search() {
        return this.jdbcTemplate.query(FIND_ALL, customerRowMapper);
    }
}
