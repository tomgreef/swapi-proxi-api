package com.diverger.prueba.app.exception;

import org.springdoc.api.OpenApiResourceNotFoundException;

public class MultiplePeopleFoundException extends OpenApiResourceNotFoundException {
    public MultiplePeopleFoundException(String message) {
        super(message);
    }
}