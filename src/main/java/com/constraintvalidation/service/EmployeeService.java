package com.constraintvalidation.service;


import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

public interface EmployeeService {


    @Retryable(retryFor = RuntimeException.class, maxAttempts = 5)
    public String getMessage();

    @Recover
    public String getRecoverMessage();
}
