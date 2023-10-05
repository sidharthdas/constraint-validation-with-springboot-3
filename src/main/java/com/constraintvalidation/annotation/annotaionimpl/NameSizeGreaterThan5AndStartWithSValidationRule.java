package com.constraintvalidation.annotation.annotaionimpl;

import com.constraintvalidation.annotation.NameSizeGreaterThan5AndStartWithS;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameSizeGreaterThan5AndStartWithSValidationRule
        implements ConstraintValidator<NameSizeGreaterThan5AndStartWithS, String> {
    @Override
    public void initialize(NameSizeGreaterThan5AndStartWithS constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return (s != null && s.length() > 5 && (s.charAt(0) + "").equals("S"));
    }
}
