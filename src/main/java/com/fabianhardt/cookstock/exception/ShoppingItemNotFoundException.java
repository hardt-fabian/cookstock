package com.fabianhardt.cookstock.exception;

import com.fabianhardt.cookstock.entity.Item;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when an {@link Item} with a given id cannot be found.
 * <p>
 * This exception results in an HTTP 404 (Not Found) response.
 *
 * @author Fabian Hardt
 */
//TODO JavaDoc
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ShoppingItemNotFoundException extends RuntimeException {

    /**
     * Constructor
     *
     * @param id the id of the item which could not be found
     */
    public ShoppingItemNotFoundException(Long id) {
        super("Shopping item with id " + id + " not found");
    }
}
