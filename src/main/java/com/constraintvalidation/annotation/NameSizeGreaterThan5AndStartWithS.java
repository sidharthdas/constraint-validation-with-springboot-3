package com.constraintvalidation.annotation;

import com.constraintvalidation.annotation.annotaionimpl.NameSizeGreaterThan5AndStartWithSValidationRule;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = NameSizeGreaterThan5AndStartWithSValidationRule.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NameSizeGreaterThan5AndStartWithS {

    String message() default "Attribute cant be null, cant be less than 5 and always starts with S";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
