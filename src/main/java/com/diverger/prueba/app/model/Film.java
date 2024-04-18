package com.diverger.prueba.app.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Film {

    @NotNull
    @Size(max = 255)
    private String title;

    @NotNull
    private Integer episodeId;

    @NotNull
    @Size(max = 255)
    private String openingCrawl;

    @NotNull
    @Size(max = 255)
    private String director;

    @NotNull
    @Size(max = 255)
    private String producer;

    @NotNull
    @Size(max = 255)
    private String releaseDate;

    @NotNull
    private List<@Size(max = 255) String> characters;

    @NotNull
    private List<@Size(max = 255) String> planets;

    @NotNull
    private List<@Size(max = 255) String> starships;

    @NotNull
    private List<@Size(max = 255) String> vehicles;

    @NotNull
    private List<@Size(max = 255) String> species;

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
