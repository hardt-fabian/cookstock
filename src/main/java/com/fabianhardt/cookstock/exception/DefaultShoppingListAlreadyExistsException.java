package com.fabianhardt.cookstock.exception;

import com.fabianhardt.cookstock.entity.ShoppingList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a default {@link ShoppingList} already exists.
 * <p>
 * This exception results in an HTTP 409 (Conflict) response.
 *
 * @author Fabian Hardt
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class DefaultShoppingListAlreadyExistsException extends RuntimeException {

    /**
     * Constructor
     */
    public DefaultShoppingListAlreadyExistsException() {
        super("A default shopping list already exists");
    }
}
