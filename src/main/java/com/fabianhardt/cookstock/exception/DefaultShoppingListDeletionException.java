package com.fabianhardt.cookstock.exception;

import com.fabianhardt.cookstock.entity.ShoppingList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when the default {@link ShoppingList} was intended to be deleted.
 * <p>
 * This exception results in an HTTP 409 (Conflict) response.
 *
 * @author Fabian Hardt
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class DefaultShoppingListDeletionException extends RuntimeException {

    /**
     * Constructor
     */
    public DefaultShoppingListDeletionException() {
        super("Default shopping list cannot be deleted. Create another list first.");
    }
}
