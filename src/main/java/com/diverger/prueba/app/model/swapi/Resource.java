package com.diverger.prueba.app.model.swapi;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Resource implements ResourceSchema {
    @NotNull
    @Size(max = 255)
    private String url;

    @NotNull
    @Size(max = 255)
    private String created;

    @NotNull
    @Size(max = 255)
    private String edited;
}
