package com.fabianhardt.cookstock.exception;

import com.fabianhardt.cookstock.entity.ShoppingList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when an {@link ShoppingList} with a given id cannot be found.
 * <p>
 * This exception results in an HTTP 404 (Not Found) response.
 *
 * @author Fabian Hardt
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ShoppingListNotFoundException extends RuntimeException {

    /**
     * Constructor
     *
     * @param id the id of the shopping list which could not be found
     */
    public ShoppingListNotFoundException(Long id) {
        super("Shopping list with id " + id + " not found");
    }
}
