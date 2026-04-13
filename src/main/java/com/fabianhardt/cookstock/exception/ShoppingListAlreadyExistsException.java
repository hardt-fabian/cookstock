package com.fabianhardt.cookstock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ShoppingListAlreadyExistsException extends RuntimeException {

    public ShoppingListAlreadyExistsException(String shoppingListName) {
        super("Shopping list with name " + shoppingListName + " already exists");
    }
}
