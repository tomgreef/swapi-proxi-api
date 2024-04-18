package com.diverger.prueba.app.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Vehicle {

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    @Size(max = 255)
    private String model;

    @NotNull
    @Size(max = 255)
    private String vehicleClass;

    @NotNull
    @Size(max = 255)
    private String manufacturer;

    @NotNull
    @Size(max = 255)
    private String costInCredits;

    @NotNull
    @Size(max = 255)
    private String length;

    @NotNull
    @Size(max = 255)
    private String crew;

    @NotNull
    @Size(max = 255)
    private String passengers;

    @NotNull
    @Size(max = 255)
    private String maxAtmospheringSpeed;

    @NotNull
    @Size(max = 255)
    private String cargoCapacity;

    @NotNull
    @Size(max = 255)
    private String consumables;

    @NotNull
    private List<@Size(max = 255) String> films;

    @NotNull
    private List<@Size(max = 255) String> pilots;

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
