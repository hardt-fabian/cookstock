package com.fabianhardt.cookstock.exception;

import com.fabianhardt.cookstock.entity.Location;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when an {@link Location} with a given id cannot be found.
 * <p>
 * This exception results in an HTTP 404 (Not Found) response.
 *
 * @author Fabian Hardt
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class LocationNotFoundException extends RuntimeException {

    /**
     * Constructor
     *
     * @param id the id of the location which could not be found
     */
    public LocationNotFoundException(Long id) {
        super("Location with id " + id + " not found");
    }
}
