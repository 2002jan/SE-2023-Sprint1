package pl.put.poznan.building.rest.exceptions;

/**
 * Model of API response that carries an exception
 */
public class ErrorResponse {

    /**
     * Exception cause
     */
    private final String message;

    public String getMessage() {
        return message;
    }

    public ErrorResponse(String message){
        super();
        this.message = message;
    }

}