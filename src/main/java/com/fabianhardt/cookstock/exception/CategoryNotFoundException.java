package com.fabianhardt.cookstock.exception;

import com.fabianhardt.cookstock.entity.Category;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when an {@link Category} with a given id cannot be found.
 * <p>
 * This exception results in an HTTP 404 (Not Found) response.
 *
 * @author Fabian Hardt
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException {

    /**
     * Constructor
     *
     * @param id the id of the category which could not be found
     */
    public CategoryNotFoundException(Long id) {
        super("category with id " + id + " not found");
    }
}
