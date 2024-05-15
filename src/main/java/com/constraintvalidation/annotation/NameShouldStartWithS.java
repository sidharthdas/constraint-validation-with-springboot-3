package com.constraintvalidation.annotation;

import com.constraintvalidation.annotation.annotaionimpl.NameShouldStartWithSImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameShouldStartWithSImpl.class)
public @interface NameShouldStartWithS {

    String message() default "Name should start with S";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
