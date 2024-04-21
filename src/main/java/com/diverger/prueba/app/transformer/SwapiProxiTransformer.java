package com.diverger.prueba.app.transformer;


import com.diverger.prueba.app.model.PersonInfo;
import com.diverger.prueba.app.model.Film;
import com.diverger.prueba.app.model.swapi.Person;
import com.diverger.prueba.app.model.swapi.Planet;
import com.diverger.prueba.app.model.swapi.Vehicle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SwapiProxiTransformer {

    public void mapPeopleToPersonInfo(Person person, PersonInfo personInfo) {
        personInfo.setName(person.getName());
        personInfo.setBirthYear(person.getBirthYear());
        personInfo.setGender(person.getGender());
    }

    public void mapPlanetToPersonInfo(Planet planet, PersonInfo personInfo) {
        personInfo.setPlanetName(planet.getName());
    }

    public void mapVehicleToPersonInfo(Vehicle vehicle, PersonInfo personInfo) {
        personInfo.setFastestVehicleDriven(vehicle.getName());
    }

    public void mapFilmsToPersonInfo(List<com.diverger.prueba.app.model.swapi.Film> swapiFilms, PersonInfo personInfo) {
        List<Film> films = new ArrayList<>();

        swapiFilms.forEach(swapiFilm -> {
                    Film film = new Film();

                    film.setName(swapiFilm.getTitle());
                    film.setReleaseDate(swapiFilm.getReleaseDate());

                    films.add(film);
                }
        );
        
        personInfo.setFilms(films);
    }
}
