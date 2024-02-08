package com.obsms.test.api.commons.exception.handler;

import com.obsms.test.api.commons.abs.AbstractBasicErrorHandler;
import com.obsms.test.api.commons.abs.IBasicErrorHandler;
import com.obsms.test.api.commons.abs.IErrorHandler;
import com.obsms.test.api.commons.exception.BadRequestException;
import com.obsms.test.api.commons.exception.ErrorResponse;
import com.obsms.test.api.commons.exception.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * {@link ControllerAdvice} for all {@link BadRequestException}.
 *
 * @author Ikram Samaad.
 * @see AbstractBasicErrorHandler
 * @see IBasicErrorHandler
 * @see IErrorHandler
 */
@ControllerAdvice
public class BadRequestExceptionHandler
        extends AbstractBasicErrorHandler<BadRequestException> {

    @ResponseBody
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @Override
    public ResponseEntity<ErrorResponse> handler(BadRequestException ex) {
        ErrorResponse response =
                new ErrorResponse(ErrorType.INPUT.name(), ex.getMessage());
        logError(request, ex);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
