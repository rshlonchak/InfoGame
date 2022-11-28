package com.example.infogame.validation;

public interface DtoValidator<T> {
    void validate(T instance) throws ValidationException;
}
