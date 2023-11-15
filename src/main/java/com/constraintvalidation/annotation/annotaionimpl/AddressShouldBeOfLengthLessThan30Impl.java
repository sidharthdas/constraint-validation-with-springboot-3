package com.constraintvalidation.annotation.annotaionimpl;

import com.constraintvalidation.annotation.AddressShouldBeOfLengthLessThan30;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AddressShouldBeOfLengthLessThan30Impl implements ConstraintValidator<AddressShouldBeOfLengthLessThan30, String> {
    @Override
    public void initialize(AddressShouldBeOfLengthLessThan30 constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = s.length() < 30;
        if (!isValid) {
            // Add a constraint violation
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("Address should be of less than 30 chars")
                    .addConstraintViolation();
        }
        return isValid;
    }
}
