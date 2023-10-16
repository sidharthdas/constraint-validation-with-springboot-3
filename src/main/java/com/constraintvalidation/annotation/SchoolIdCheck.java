package com.constraintvalidation.annotation;

import com.constraintvalidation.annotation.annotaionimpl.SchoolIdCheckImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SchoolIdCheckImpl.class)
public @interface SchoolIdCheck {
    String message() default "School ID should starts with SCHOOL";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
