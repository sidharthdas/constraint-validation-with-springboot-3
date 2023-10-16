package com.constraintvalidation.annotation;

import com.constraintvalidation.annotation.annotaionimpl.SchoolAddressCheckImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SchoolAddressCheckImpl.class)
public @interface SchoolAddressCheck {

    String message() default "Address line should not be more than 30 char";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
