package com.fabianhardt.cookstock.exception;

import com.fabianhardt.cookstock.entity.ShoppingList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a {@link ShoppingList} with a given name already exists.
 * <p>
 * This exception results in an HTTP 409 (Conflict) response.
 *
 * @author Fabian Hardt
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class ShoppingListAlreadyExistsException extends RuntimeException {

    /**
     * Constructor
     *
     * @param name the name of the shopping list which already exists
     */
    public ShoppingListAlreadyExistsException(String name) {
        super("Shopping list with name " + name + " already exists");
    }
}
