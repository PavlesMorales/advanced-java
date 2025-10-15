package ru.antonov.client.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.antonov.client.service.exception.ClientNotFoundException;
import ru.antonov.client.service.exception.ClientPersonDataNotFound;

@ControllerAdvice
public class AdviceController extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ClientNotFoundException.class, ClientPersonDataNotFound.class})
    public ResponseEntity<?> handleNotFoundException(Exception ex, WebRequest request) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
    }
}
