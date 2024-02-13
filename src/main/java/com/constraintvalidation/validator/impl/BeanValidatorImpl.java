package com.constraintvalidation.validator.impl;

import com.constraintvalidation.validator.BeanValidator;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class BeanValidatorImpl implements BeanValidator {

    private ValidatorFactory validatorFactory;
    private Validator validator;

    @PostConstruct
    public void init() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();

    }
    @Override
    public Set<String> validate(Object obj) {
        Set<ConstraintViolation<Object>> errors = validator.validate(obj);
        Set<String> result = new HashSet<>();
        errors.forEach(error -> result.add(error.getMessage()));
        return result;
    }

    @PreDestroy
    public void close() {
        validatorFactory.close();
    }
}
