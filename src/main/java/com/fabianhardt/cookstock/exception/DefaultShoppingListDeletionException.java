package com.fabianhardt.cookstock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DefaultShoppingListDeletionException extends RuntimeException {

    public DefaultShoppingListDeletionException() {
        super("Default shopping list cannot be deleted. Create another list first.");
    }
}
