package com.fabianhardt.cookstock.exception;

import com.fabianhardt.cookstock.entity.Category;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when an {@link Category} with a given name already exists.
 * <p>
 * This exception results in an HTTP 409 (Conflict) response.
 *
 * @author Fabian Hardt
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class CategoryAlreadyExistsException extends RuntimeException {

    /**
     * Constructor
     *
     * @param name the name of the category which already exists
     */
    public CategoryAlreadyExistsException(String name) {
        super("Category with name " + name + " already exists");
    }
}
