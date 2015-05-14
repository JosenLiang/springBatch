package com.thoughtworks.springBatch;

import com.thoughtworks.springBatch.model.Customer;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.support.AbstractItemStreamItemWriter;

import java.util.List;

import static java.lang.System.out;

public class CommandLineItemWriter extends AbstractItemStreamItemWriter<Customer> {
    private static final String STATE_KEY = "CURRENT_INDEX";
    private int currentProcessedNumber;

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        if (executionContext.containsKey(STATE_KEY)) {
            currentProcessedNumber = executionContext.getInt(STATE_KEY);
        } else {
            currentProcessedNumber = 0;
        }
    }

    @Override
    public void update(ExecutionContext executionContext) {
        executionContext.put(STATE_KEY, currentProcessedNumber);
    }

    @Override
    public void write(List<? extends Customer> items) throws Exception {
        out.println("===================================================");
        for (Customer customer : items) {
            out.println(customer);
        }
        currentProcessedNumber += items.size();
    }
}
