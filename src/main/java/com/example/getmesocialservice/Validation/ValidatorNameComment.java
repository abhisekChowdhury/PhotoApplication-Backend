package com.example.getmesocialservice.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class ValidatorNameComment implements ConstraintValidator<ValidNameComment, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        if (s.matches("[a-z0-9]*$")) {
            return true;
        } else {
            return false;
        }
    }
}
