package com.fabianhardt.cookstock.exception;

import com.fabianhardt.cookstock.entity.Item;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when an {@link Item} with a given name already exists.
 * <p>
 * This exception results in an HTTP 409 (Conflict) response.
 *
 * @author Fabian Hardt
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class ItemAlreadyExistsException extends RuntimeException {

    /**
     * Constructor
     *
     * @param name the name of the item which already exists
     */
    public ItemAlreadyExistsException(String name) {
        super("Item with name " + name + " already exists");
    }
}
