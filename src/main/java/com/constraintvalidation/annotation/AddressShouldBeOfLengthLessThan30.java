package com.constraintvalidation.annotation;

import com.constraintvalidation.annotation.annotaionimpl.AddressShouldBeOfLengthLessThan30Impl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AddressShouldBeOfLengthLessThan30Impl.class)
public @interface AddressShouldBeOfLengthLessThan30 {

    String message() default "length is more than 30";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
