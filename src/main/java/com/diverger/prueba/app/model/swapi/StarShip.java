package com.diverger.prueba.app.model.swapi;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StarShip extends Vehicle {

    @NotNull
    @Size(max = 255)
    private String hyperdriveRating;

    @NotNull
    @Size(max = 255)
    @JsonProperty("MGLT")
    private String maximumMegalightsPerStandardHour;

    @NotNull
    @Size(max = 255)
    private String starshipClass;

    @Override
    public String getVehicleClass() {
        return starshipClass;
    }

    @Override
    public void setVehicleClass(String vehicleClass) {
        this.starshipClass = vehicleClass;
    }

    @Override
    public String getResourceName() {
        return "starships";
    }
}
