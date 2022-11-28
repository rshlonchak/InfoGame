package com.example.infogame.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

public class DtoValidatorImpl<T> implements DtoValidator<T>{

    public void validate(T instance) throws ValidationException {
        try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<T>> violations = validator.validate(instance);
            if (violations.isEmpty()) return;
            List<String> violationMessages = violations.stream().map(ConstraintViolation::getMessage).toList();
            throw new ValidationException("Validation failed. Reasons: " + violationMessages);
        }
    }
}
