package pl.put.poznan.building.rest.exceptions;

import org.springframework.http.HttpStatus;

/**
 * This exception indicates that some resource does not exist
 */
public abstract class NotFoundException extends BaseException{
    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
