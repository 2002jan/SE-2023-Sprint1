package pl.put.poznan.building.exceptions;

import org.springframework.http.HttpStatus;

public abstract class NotFoundException extends BaseException{
    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
