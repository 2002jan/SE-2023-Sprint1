package pl.put.poznan.building.exceptions;

public class ErrorResponse {
    private final String message;

    public String getMessage() {
        return message;
    }

    public ErrorResponse(String message){
        super();
        this.message = message;
    }

}