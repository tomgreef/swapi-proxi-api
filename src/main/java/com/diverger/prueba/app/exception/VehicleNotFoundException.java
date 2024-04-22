package com.diverger.prueba.app.exception;

import org.springdoc.api.OpenApiResourceNotFoundException;

public class VehicleNotFoundException extends OpenApiResourceNotFoundException {
    public VehicleNotFoundException(Integer id) {
        super("Vehicle not found with id: " + id);
    }
}