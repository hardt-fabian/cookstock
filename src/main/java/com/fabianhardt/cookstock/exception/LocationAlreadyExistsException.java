package com.fabianhardt.cookstock.exception;

import com.fabianhardt.cookstock.entity.Location;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a {@link Location} with a given name already exists.
 * <p>
 * This exception results in an HTTP 409 (Conflict) response.
 *
 * @author Fabian Hardt
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class LocationAlreadyExistsException extends RuntimeException {

    /**
     * Constructor
     *
     * @param name the name of the location which already exists
     */
    public LocationAlreadyExistsException(String name) {
        super("Location with name " + name + " already exists");
    }
}
