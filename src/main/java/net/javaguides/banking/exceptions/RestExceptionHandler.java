package net.javaguides.banking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = NoAccountFoundException.class)
    public ResponseEntity<ApiResponseError> handleNoAccountFoundException(){
        ApiResponseError error = new ApiResponseError(400, "Account not found", new Date());
        return  new ResponseEntity<ApiResponseError>(error,HttpStatus.BAD_REQUEST);
    }
}
