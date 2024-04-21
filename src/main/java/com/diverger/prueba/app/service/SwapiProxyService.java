package com.diverger.prueba.app.service;

import com.diverger.prueba.app.client.SwapiApiClient;
import com.diverger.prueba.app.exception.*;
import com.diverger.prueba.app.model.PersonInfo;
import com.diverger.prueba.app.model.swapi.*;
import com.diverger.prueba.app.transformer.SwapiProxiTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class SwapiProxyService {

    private final SwapiApiClient apiClient;
    private final SwapiProxiTransformer transformer;

    public PersonInfo getPersonInfo(String name) {
        Search<Person> search = apiClient.getResourceBySearch(Person.class, name, new PersonSearchTypeRef()).block();
        assert search != null;
        List<Person> personList = search.getResults();
        Integer peopleSearchCount = search.getCount();

        if (peopleSearchCount > 1) {
            throw new MultiplePeopleFoundException("More than one person found with the name: " + name);
        }

        if (peopleSearchCount == 0) {
            throw new PersonNotFoundException();
        }

        PersonInfo personInfo = new PersonInfo();

        Person person = personList.get(0);
        transformer.mapPeopleToPersonInfo(person, personInfo);

        Planet planet = getPlanet(idFromUrl(person.getHomeworld()));
        transformer.mapPlanetToPersonInfo(planet, personInfo);

        Vehicle vehicle = getFastestVehicle(idsFromUrls(person.getVehicles()), idsFromUrls(person.getStarships()));
        transformer.mapVehicleToPersonInfo(vehicle, personInfo);

        List<Film> films = getFilms(idsFromUrls(person.getFilms()));
        transformer.mapFilmsToPersonInfo(films, personInfo);

        return personInfo;
    }

    public Planet getPlanet(Integer planetId) {
        Optional<Planet> optionalPlanet = apiClient.getResourceById(Planet.class, planetId).blockOptional();

        if (optionalPlanet.isEmpty()) {
            throw new PlanetNotFoundException();
        }

        return optionalPlanet.get();
    }

    public Vehicle getFastestVehicle(List<Integer> vehicleIds, List<Integer> starshipIds) {
        Vehicle fastestVehicle = getFastestVehicleFromList(vehicleIds, Vehicle.class);
        Vehicle fastestStarship = getFastestVehicleFromList(starshipIds, StarShip.class);

        return isFasterVehicle(fastestStarship, fastestVehicle) ? fastestStarship : fastestVehicle;
    }

    private List<Film> getFilms(List<Integer> filmIds) {
        List<Film> films = new ArrayList<>();

        for (Integer filmId : filmIds) {
            Optional<Film> optionalFilm = apiClient.getResourceById(Film.class, filmId).blockOptional();

            if (optionalFilm.isEmpty()) {
                throw new FilmNotFoundException(filmId);
            }

            films.add(optionalFilm.get());
        }

        return films;
    }

    private <T extends Vehicle> T getFastestVehicleFromList(List<Integer> vehicleIds, Class<T> vehicleClass) {
        T fastestVehicle = null;

        for (Integer vehicleId : vehicleIds) {
            Optional<T> optionalVehicle = apiClient.getResourceById(vehicleClass, vehicleId).blockOptional();

            if (optionalVehicle.isEmpty()) {
                throw new VehicleNotFoundException(vehicleId);
            }

            T vehicle = optionalVehicle.get();
            if (isFasterVehicle(vehicle, fastestVehicle)) {
                fastestVehicle = vehicle;
            }
        }

        return fastestVehicle;
    }

    private boolean isFasterVehicle(Vehicle vehicle, Vehicle currentFastestVehicle) {
        Integer vehicleSpeed = parseSpeed(vehicle);
        Integer currentFastestVehicleSpeed = parseSpeed(currentFastestVehicle);

        return vehicleSpeed > currentFastestVehicleSpeed;
    }

    private Integer parseSpeed(Vehicle vehicle) {
        if (vehicle == null || vehicle.getMaxAtmospheringSpeed() == null) {
            return 0;
        }

        try {
            return Integer.parseInt(vehicle.getMaxAtmospheringSpeed());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private List<Integer> idsFromUrls(List<String> urls) {
        return urls.stream()
                .map(this::idFromUrl)
                .toList();
    }

    private Integer idFromUrl(String url) {
        String[] urlParts = url.split("/");
        return Integer.parseInt(urlParts[urlParts.length - 1]);
    }
}