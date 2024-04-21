package com.diverger.prueba.app.exception;

import org.springdoc.api.OpenApiResourceNotFoundException;

public class PlanetNotFoundException extends OpenApiResourceNotFoundException {

    public PlanetNotFoundException() {
        super("Planet not found.");
    }
}