package com.example.getmesocialservice.Validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidatorNamePhoto.class)
@Documented
public @interface ValidNamePhoto {
    String message() default "not a valid name for createdBy field of Photo class";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
