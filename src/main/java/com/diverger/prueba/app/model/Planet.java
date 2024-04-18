package com.diverger.prueba.app.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Planet {

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    @Size(max = 255)
    private String diameter;

    @NotNull
    @Size(max = 255)
    private String rotationPeriod;

    @NotNull
    @Size(max = 255)
    private String orbitalPeriod;

    @NotNull
    @Size(max = 255)
    private String gravity;

    @NotNull
    @Size(max = 255)
    private String population;

    @NotNull
    @Size(max = 255)
    private String climate;

    @NotNull
    @Size(max = 255)
    private String terrain;

    @NotNull
    @Size(max = 255)
    private String surfaceWater;

    @NotNull
    private List<@Size(max = 255) String> films;

    @NotNull
    private List<@Size(max = 255) String> residents;

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
