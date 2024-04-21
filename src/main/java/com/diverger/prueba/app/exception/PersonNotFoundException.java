package com.diverger.prueba.app.exception;

import org.springdoc.api.OpenApiResourceNotFoundException;

public class PersonNotFoundException extends OpenApiResourceNotFoundException {

    public PersonNotFoundException() {
        super("Person not found.");
    }
}