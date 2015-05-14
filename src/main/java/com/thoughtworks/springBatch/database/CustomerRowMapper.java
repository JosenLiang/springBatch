package com.thoughtworks.springBatch.database;

import com.thoughtworks.springBatch.model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt("ID"));
        customer.setFirstName(rs.getString("FIRST_NAME"));
        customer.setMiddleName(rs.getString("MIDDLE_NAME"));
        customer.setLastName(rs.getString("LAST_NAME"));
        customer.setAddressNumber(rs.getString("ADDRESS_NUMBER"));
        customer.setStreet(rs.getString("STREET"));
        customer.setCity(rs.getString("CITY"));
        return customer;
    }
}
