package com.constraintvalidation.annotation.annotaionimpl;

import com.constraintvalidation.annotation.NameShouldStartWithS;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameShouldStartWithSImpl implements ConstraintValidator<NameShouldStartWithS, String> {
    @Override
    public void initialize(NameShouldStartWithS constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && s.charAt(0) == 'S';
    }
}
