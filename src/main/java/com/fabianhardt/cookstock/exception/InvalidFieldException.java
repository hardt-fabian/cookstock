package com.fabianhardt.cookstock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a field invalid. For further information consider the message.
 * <p>
 * This exception results in an HTTP 400 (Bad Request) response.
 *
 * @author Fabian Hardt
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidFieldException extends RuntimeException {

    /**
     * Constructor
     *
     * @param message the message which explains the invalidation
     */
    public InvalidFieldException(String message) {
        super(message);
    }
}
