package com.diverger.prueba.app.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PersonInfo {

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    @Size(max = 255)
    private String birthYear;

    @NotNull
    @Size(max = 255)
    private String gender;

    @NotNull
    @Size(max = 255)
    private String planetName;

    @NotNull
    @Size(max = 255)
    private String fastestVehicleDriven;

    @NotNull
    @Valid
    private List<FilmDTO> films;

}
