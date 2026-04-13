package com.fabianhardt.cookstock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class LocationAlreadyExistsException extends RuntimeException {

    public LocationAlreadyExistsException(String locationName) {
        super("Location with name " + locationName + " already exists");
    }
}
