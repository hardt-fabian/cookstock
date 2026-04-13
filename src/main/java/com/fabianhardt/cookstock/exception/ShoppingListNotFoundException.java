package com.fabianhardt.cookstock.exception;

public class ShoppingListNotFoundException extends RuntimeException {

    public ShoppingListNotFoundException(Long id) {
        super("Shopping list with id " + id + " not found");
    }
}
