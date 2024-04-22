package com.diverger.prueba.app.exception;

import org.springdoc.api.OpenApiResourceNotFoundException;

public class ResourceNameException extends OpenApiResourceNotFoundException {
    public ResourceNameException(String className) {
        super("Resource name is not valid for: " + className);
    }
}