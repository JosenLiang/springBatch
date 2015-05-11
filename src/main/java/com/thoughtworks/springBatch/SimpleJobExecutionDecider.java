package com.thoughtworks.springBatch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

import static com.google.common.base.Strings.isNullOrEmpty;

public class SimpleJobExecutionDecider implements JobExecutionDecider {

    @Override
    public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
        String message = jobExecution.getExecutionContext().getString("message");
        if (isNullOrEmpty(message) || message.length() <= 5) {
            return new FlowExecutionStatus("step2");
        } else {
            return new FlowExecutionStatus("stop");
        }
    }
}
