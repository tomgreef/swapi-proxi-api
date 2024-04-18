package com.diverger.prueba.app.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class People {

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    @Size(max = 255)
    private String height;

    @NotNull
    @Size(max = 255)
    private String mass;

    @NotNull
    @Size(max = 255)
    private String hairColor;

    @NotNull
    @Size(max = 255)
    private String skinColor;

    @NotNull
    @Size(max = 255)
    private String eyeColor;

    @NotNull
    @Size(max = 255)
    private String birthYear;

    @NotNull
    @Size(max = 255)
    private String gender;

    @NotNull
    @Size(max = 255)
    private String homeworld;

    @NotNull
    private List<@Size(max = 255) String> films;

    @NotNull
    private List<@Size(max = 255) String> species;

    @NotNull
    private List<@Size(max = 255) String> vehicles;

    @NotNull
    private List<@Size(max = 255) String> starships;

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
