package com.thoughtworks.springBatch;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;

public class CustomerPartitioner implements Partitioner {
    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {
        HashMap<String, ExecutionContext> result = new HashMap<>();

        result.put("partitioner1", new ExecutionContext(of("min", 1, "max", 2)));
        result.put("partitioner2", new ExecutionContext(of("min", 3, "max", 4)));

        return result;
    }
}
