package com.fabianhardt.cookstock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DefaultShoppingListAlreadyExistsException extends RuntimeException {

    public DefaultShoppingListAlreadyExistsException() {
        super("An default shopping list already exists");
    }
}
