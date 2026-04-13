package com.fabianhardt.cookstock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ItemAlreadyExistsException extends RuntimeException {

    public ItemAlreadyExistsException(String itemName) {
        super("Item with name " + itemName + " already exists");
    }
}
