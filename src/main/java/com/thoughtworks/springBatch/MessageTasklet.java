package com.thoughtworks.springBatch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Required;

import static org.springframework.batch.repeat.RepeatStatus.FINISHED;

public class MessageTasklet implements Tasklet {
    private String message;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        ExecutionContext executionContext = chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext();
        executionContext.put("message", message);
        return FINISHED;
    }

    @Required
    public void setMessage(String message) {
        this.message = message;
    }
}
