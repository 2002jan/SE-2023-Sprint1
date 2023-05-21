package pl.put.poznan.building.rest.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Exception thrown by application when there are problems caused by user input
 */
public abstract class BaseException extends RuntimeException  {

    /**
     * Http code of this exception
     */
    private final HttpStatus status;

    /**
     * Creates BaseException
     *
     * @param message Cause of this exception
     * @param status Http code of this exception
     */
    public BaseException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
