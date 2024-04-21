package com.diverger.prueba.app;

import com.diverger.prueba.app.client.SwapiApiClient;
import com.diverger.prueba.app.model.swapi.PersonSearchTypeRef;
import com.diverger.prueba.app.model.swapi.Person;
import com.diverger.prueba.app.model.swapi.Search;
import com.diverger.prueba.app.model.swapi.Vehicle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.test.context.ActiveProfiles;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("test")
@SpringBootTest
class SwapiApiClientTest {
    private final SwapiApiClient apiClient = new SwapiApiClient();

    @Test
    @DisplayName("getResourceBySearch returns correct resource")
    void getResourceBySearchReturnsCorrectResource() {
        Search<Person> personSearch = apiClient.getResourceBySearch(Person.class, "Luke Skywalker", new PersonSearchTypeRef()).block();

        assert personSearch != null;
        assertEquals(personSearch.getResults().get(0).getClass(), Person.class);
    }

    @Test
    @DisplayName("getResourceById returns correct resource")
    void getResourceByIdReturnsCorrectResource() {
        Vehicle vehicle = apiClient.getResourceById(Vehicle.class, 4).block();

        assert vehicle != null;
        assertEquals(vehicle.getClass(), Vehicle.class);
    }

    @Test
    @DisplayName("Cache is returning the same object and faster")
    void cacheTest() {
        long startTime = System.currentTimeMillis();
        Search<Person> personSearch = apiClient.getResourceBySearch(Person.class, "Luke Skywalker", new PersonSearchTypeRef()).block();
        long endTime = System.currentTimeMillis();
        long durationFirstQuery = endTime - startTime;
        System.out.println("First request took: " + durationFirstQuery + "ms");

        startTime = System.currentTimeMillis();
        Search<Person> personSearch2 = apiClient.getResourceBySearch(Person.class, "Luke Skywalker", new PersonSearchTypeRef()).block();
        endTime = System.currentTimeMillis();
        long durationSecondQuery = endTime - startTime;
        System.out.println("Second request took: " + durationSecondQuery + "ms");

        assert personSearch != null;
        assert personSearch2 != null;
        Person person = personSearch.getResults().get(0);
        Person person2 = personSearch2.getResults().get(0);
        assertEquals(person, person2);
        assertTrue(durationFirstQuery > durationSecondQuery);
    }
}
