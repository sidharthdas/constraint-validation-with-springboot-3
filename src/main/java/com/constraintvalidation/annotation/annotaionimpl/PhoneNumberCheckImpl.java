package com.constraintvalidation.annotation.annotaionimpl;

import com.constraintvalidation.annotation.PhoneNumberCheck;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberCheckImpl implements ConstraintValidator<PhoneNumberCheck, String> {
    @Override
    public void initialize(PhoneNumberCheck constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.length() == 10;
    }
}
