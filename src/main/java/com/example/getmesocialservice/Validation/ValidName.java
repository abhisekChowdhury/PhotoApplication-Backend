package com.example.getmesocialservice.Validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidNameValidator.class)
@Documented
public @interface ValidName {

    String message() default "not a valid name:";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
