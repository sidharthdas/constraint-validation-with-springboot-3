package com.constraintvalidation.annotation.annotaionimpl;

import com.constraintvalidation.annotation.SchoolIdCheck;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SchoolIdCheckImpl implements ConstraintValidator<SchoolIdCheck, String> {
    @Override
    public void initialize(SchoolIdCheck constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return (s.length() > 6 && s.substring(0,6).equalsIgnoreCase("SCHOOL"));
    }
}
