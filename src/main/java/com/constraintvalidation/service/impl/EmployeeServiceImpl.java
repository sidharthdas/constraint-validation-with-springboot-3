package com.constraintvalidation.service.impl;

import com.constraintvalidation.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    int count = 0;
    @Override
    public String getMessage() {
        if(count == 4) {
            return "Hello World";
        }
        System.out.println(count);
        count++;
        throw new RuntimeException("Test");
    }

    @Override
    public String getRecoverMessage() {
        return "Hello Test World";
    }
}
