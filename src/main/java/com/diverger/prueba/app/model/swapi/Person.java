package com.diverger.prueba.app.model.swapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.ParameterizedTypeReference;


@Getter
@Setter
public class Person extends Resource implements SearchTypeReference<Person> {

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
    @JsonProperty("hair_color")
    private String hairColor;

    @NotNull
    @Size(max = 255)
    @JsonProperty("skin_color")
    private String skinColor;

    @NotNull
    @Size(max = 255)
    @JsonProperty("eye_color")
    private String eyeColor;

    @NotNull
    @Size(max = 255)
    @JsonProperty("birth_year")
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

    public ParameterizedTypeReference getParameterizedSearchTypeReference() {
        return new ParameterizedTypeReference<Search<Person>>() {
        };
    }

    @Override
    public String getResourceName() {
        return "people";
    }
}
