package pl.put.poznan.building.rest.exceptions;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException  {
    private final HttpStatus status;

    public BaseException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
