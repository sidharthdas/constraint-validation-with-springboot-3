package com.constraintvalidation.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.net.URISyntaxException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ProblemDetail getErrors(Exception ee) throws URISyntaxException {
        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(400), ee.getLocalizedMessage());

        problemDetail.setTitle("BAD Request");
        problemDetail.setType(new URI("test"));
        return problemDetail;
    }
}
