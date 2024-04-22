package com.diverger.prueba.app.model.swapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Film extends Resource {

    @NotNull
    @Size(max = 255)
    private String title;

    @NotNull
    @JsonProperty("episode_id")
    private Integer episodeId;

    @NotNull
    @Size(max = 255)
    @JsonProperty("opening_crawl")
    private String openingCrawl;

    @NotNull
    @Size(max = 255)
    private String director;

    @NotNull
    @Size(max = 255)
    private String producer;

    @NotNull
    @Size(max = 255)
    @JsonProperty("release_date")
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

    public String getResourceName() {
        return "films";
    }
}
