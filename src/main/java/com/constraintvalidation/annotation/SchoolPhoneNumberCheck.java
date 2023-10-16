package com.constraintvalidation.annotation;

import com.constraintvalidation.annotation.annotaionimpl.SchoolPhoneNumberCheckImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SchoolPhoneNumberCheckImpl.class)
public @interface SchoolPhoneNumberCheck {

    String message() default "Phone number should be of 10 char";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
