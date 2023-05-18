package pl.put.poznan.building.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * Main application exception handler
 */
@ControllerAdvice
public class AppExceptionHandler {

    /**
     * Handles all exception thrown during application runtime
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse("Unexpected exception has occurred");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles application exceptions which are expected and extend BaseException class
     *
     * @param exception Instance of BaseException that was thrown during run time
     * @return Response with information provided by exception
     */
    @ExceptionHandler(value = {BaseException.class})
    public final ResponseEntity<Object> handleApplicationExceptions(BaseException exception, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
        return new ResponseEntity<>(errorResponse, exception.getStatus());
    }
}
