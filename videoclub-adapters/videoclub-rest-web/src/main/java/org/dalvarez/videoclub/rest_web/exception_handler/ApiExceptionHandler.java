package org.dalvarez.videoclub.rest_web.exception_handler;

import org.dalvarez.videoclub.domain.exceptions.BadRequestException;
import org.dalvarez.videoclub.domain.exceptions.ConflictException;
import org.dalvarez.videoclub.domain.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ApiExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(Exception ex) {
        return new ResponseEntity<>(getErrorResponse(ex, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({
            BadRequestException.class,
            HttpRequestMethodNotSupportedException.class,
            MethodArgumentNotValidException.class,
            HttpMessageNotReadableException.class
    })
    public ResponseEntity<ErrorResponse> handleBadRequestException(Exception ex) {
        return new ResponseEntity<>(getErrorResponse(ex, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
            ConflictException.class,
            ConstraintViolationException.class
    })
    public ResponseEntity<ErrorResponse> handleConflictException(Exception ex) {
        return new ResponseEntity<>(getErrorResponse(ex, HttpStatus.CONFLICT), HttpStatus.CONFLICT);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> handleInternalServerErrorException(Exception ex) {
        return new ResponseEntity<>(getErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ErrorResponse getErrorResponse(Exception ex, HttpStatus httpStatus) {
        String causeMessage = ex.getMessage();
        int httpCode = httpStatus.value();
        String httpName = httpStatus.name();
        String clazz = getClassName(ex);
        String method = ex.getStackTrace().length > 0 ? ex.getStackTrace()[0].getMethodName() : "Not found";
        int line = ex.getStackTrace().length > 0 ? ex.getStackTrace()[0].getLineNumber() : 0;

        return ErrorResponse.builder()
                .clazz(clazz)
                .httpStatus(httpCode)
                .message(causeMessage)
                .method(method)
                .type(httpName)
                .line(line)
                .build();
    }

    private String getClassName(Exception ex) {
        String className = "Not found";

        try {
            className = Class.forName(ex.getStackTrace()[0].getClassName()).getName();

        } catch (Exception ignored) {

        }

        return className;
    }

}