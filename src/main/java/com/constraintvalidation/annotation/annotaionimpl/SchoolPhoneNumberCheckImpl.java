package com.constraintvalidation.annotation.annotaionimpl;

import com.constraintvalidation.annotation.SchoolPhoneNumberCheck;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SchoolPhoneNumberCheckImpl implements ConstraintValidator<SchoolPhoneNumberCheck, String> {
    @Override
    public void initialize(SchoolPhoneNumberCheck constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.length() == 10;
    }
}
