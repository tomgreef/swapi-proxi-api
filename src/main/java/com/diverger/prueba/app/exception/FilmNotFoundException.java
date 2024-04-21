package com.diverger.prueba.app.exception;

import org.springdoc.api.OpenApiResourceNotFoundException;

public class FilmNotFoundException extends OpenApiResourceNotFoundException {
    public FilmNotFoundException(Integer filmId) {
        super("Film not found with ID: " + filmId);
    }
}