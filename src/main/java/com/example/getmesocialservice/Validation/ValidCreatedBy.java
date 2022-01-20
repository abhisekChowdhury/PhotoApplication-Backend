package com.example.getmesocialservice.Validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidCreatedValidator.class)
@Documented
public @interface ValidCreatedBy {
    String message() default "not a valid name for createdBy field :";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
