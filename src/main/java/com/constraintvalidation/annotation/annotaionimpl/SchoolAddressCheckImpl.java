package com.constraintvalidation.annotation.annotaionimpl;

import com.constraintvalidation.annotation.SchoolAddressCheck;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SchoolAddressCheckImpl implements ConstraintValidator<SchoolAddressCheck, String> {
    @Override
    public void initialize(SchoolAddressCheck constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.length() < 30;
    }
}
