package com.diverger.prueba.app.client;

import com.diverger.prueba.app.exception.ResourceNameException;
import com.diverger.prueba.app.model.swapi.Resource;
import com.diverger.prueba.app.model.swapi.Search;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class SwapiApiClient {

    private final WebClient webClient;

    public SwapiApiClient() {
        this.webClient = WebClient.create("https://swapi.dev/api/");
    }

    @Cacheable(value = "search", key = "#resourceClass.getName() + #search")
    public <T extends Resource> Mono<Search<T>> getResourceBySearch(Class<T> resourceClass, String search, ParameterizedTypeReference<Search<T>> typeRef) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(getResourceName(resourceClass) + "/")
                        .queryParam("search", search)
                        .build())
                .retrieve()
                .bodyToMono(typeRef);
    }

    @Cacheable(value = "resource", key = "#resourceClass.getName() + #resourceId")
    public <T extends Resource> Mono<T> getResourceById(Class<T> resourceClass, Integer resourceId) {
        return webClient.get()
                .uri(getResourceName(resourceClass) + "/" + resourceId)
                .retrieve()
                .bodyToMono(resourceClass);
    }


    private <T extends Resource> String getResourceName(Class<T> resourceClass) {
        try {
            return resourceClass.getDeclaredConstructor().newInstance().getResourceName();
        } catch (Exception e) {
            throw new ResourceNameException(resourceClass.getSimpleName());
        }
    }

}