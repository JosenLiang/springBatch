package com.thoughtworks.springBatch;

import com.thoughtworks.springBatch.model.Customer;
import org.springframework.batch.core.listener.ItemListenerSupport;

import static java.lang.System.out;

public class LogExceptionListener extends ItemListenerSupport<Customer, Customer> {
    @Override
    public void onProcessError(Customer item, Exception e) {
        out.println("Exception happened: " + item);
    }
}
