package com.irctc.backend.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CoachValidator implements ConstraintValidator<ValidCoach, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
//        logic to validate the coach(Validation logic)
        if(value>100)
        {
            return true;
        }
        return false;
    }
}
