package com.diverger.prueba.app.model.swapi;

import org.springframework.core.ParameterizedTypeReference;

public interface SearchTypeReference<T extends Resource> {
    ParameterizedTypeReference<Search<T>> getParameterizedSearchTypeReference();
}
