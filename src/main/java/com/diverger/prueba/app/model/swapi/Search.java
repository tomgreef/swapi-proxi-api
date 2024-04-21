package com.diverger.prueba.app.model.swapi;

import com.diverger.prueba.app.exception.NullCountException;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Search<T extends Resource> {
    private Integer count;
    private String next;
    private String previous;
    private List<T> results;

    public Integer getCount() {
        if (count == null) {
            throw new NullCountException("Error getting count on search, count is null");
        }

        return count;
    }
}
