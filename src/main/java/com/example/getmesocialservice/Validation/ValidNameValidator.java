package com.example.getmesocialservice.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


//constraintValidator<A, T> : annotation interface- ValidName and T: String is type of name.
public class ValidNameValidator implements ConstraintValidator<ValidName,String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        if (s.matches("[a-zA-Z .]+")) {
            return true;
        } else {
            return false;
        }
    }
}