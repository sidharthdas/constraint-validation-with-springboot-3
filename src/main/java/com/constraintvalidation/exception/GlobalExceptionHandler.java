package com.constraintvalidation.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ProblemDetail getErrors(Exception ee, WebRequest e1) throws URISyntaxException {
        ErrorDetail detail = new ErrorDetail(LocalDateTime.now(), ee.getMessage(), e1.getDescription(false), new LinkedHashMap<>(Map.of("test", "test1")));
        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(400), "");

        problemDetail.setTitle("BAD Request");
        problemDetail.setType(new URI("test"));
        problemDetail.setProperty("errorDetails", detail);
        return problemDetail;
    }
}
