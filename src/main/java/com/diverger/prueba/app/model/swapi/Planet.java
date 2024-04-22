package com.diverger.prueba.app.model.swapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Planet extends Resource {

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    @Size(max = 255)
    private String diameter;

    @NotNull
    @Size(max = 255)
    @JsonProperty("rotation_period")
    private String rotationPeriod;

    @NotNull
    @Size(max = 255)
    @JsonProperty("orbital_period")
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
    @JsonProperty("surface_water")
    private String surfaceWater;

    @NotNull
    private List<@Size(max = 255) String> films;

    @NotNull
    private List<@Size(max = 255) String> residents;

    @Override
    public String getResourceName() {
        return "planets";
    }
}
