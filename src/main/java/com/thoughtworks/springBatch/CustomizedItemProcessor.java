package com.thoughtworks.springBatch;

import com.thoughtworks.springBatch.model.Customer;
import org.springframework.batch.item.ItemProcessor;

import java.security.InvalidParameterException;

public class CustomizedItemProcessor implements ItemProcessor<Customer, Customer> {

    @Override
    public Customer process(Customer item) throws Exception {
        if (item.getId() < 2) {
            throw new InvalidParameterException("The item is invalid");
        } else {
            return item;
        }
    }
}
