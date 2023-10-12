package com.constraintvalidation.annotation;

import com.constraintvalidation.annotation.annotaionimpl.PhoneNumberCheckImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = PhoneNumberCheckImpl.class)
public @interface PhoneNumberCheck {

    String message() default "Phone number size should be 10";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
