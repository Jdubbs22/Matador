package edu.depaul.cdm.se.matador.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<MatadorErrorResponse> handlerRestException(ResponseStatusException e) {

        MatadorErrorResponse errorResponse = new MatadorErrorResponse();
        errorResponse.setReason(e.getReason());
        return ResponseEntity
                .status(e.getStatus())
                .body(errorResponse);
    }


}
