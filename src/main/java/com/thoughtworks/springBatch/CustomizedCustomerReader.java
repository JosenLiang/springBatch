package com.thoughtworks.springBatch;

import com.thoughtworks.springBatch.model.Customer;
import org.springframework.batch.item.*;
import org.springframework.batch.item.support.AbstractItemStreamItemReader;

import java.util.ArrayList;
import java.util.List;

public class CustomizedCustomerReader extends AbstractItemStreamItemReader<Customer> {
    private static final String STATE_KEY = "CURRENT_INDEX";
    private int currentIndex;
    private List<Customer> allCustomers;

    public CustomizedCustomerReader() {
        this.currentIndex = 0;
        this.allCustomers = generateCustomer();
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        if (executionContext.containsKey(STATE_KEY)) {
            currentIndex = executionContext.getInt(STATE_KEY);
        } else {
            currentIndex = 0;
        }
    }

    @Override
    public void update(ExecutionContext executionContext) {
        executionContext.put(STATE_KEY, currentIndex);
    }

    @Override
    public Customer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (currentIndex < allCustomers.size()) {
            Customer customer = allCustomers.get(currentIndex);
            currentIndex++;
            return customer;
        } else {
            return null;
        }
    }

    private List<Customer> generateCustomer() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Michael", "T", "Smith", "123", "4th Street", "Chicago"));
        customers.add(new Customer(2, "Warren", "Q", "Gates", "11", "Wall Street", "New York"));
        customers.add(new Customer(3, "Ann", "B", "Darrow", "350", "Fifth Avenue", "New York"));
        customers.add(new Customer(4, "Terrence", "H", "Donnelly", "4059", "Mt. Lee Drive", "Hollywood"));
        return customers;
    }
}
