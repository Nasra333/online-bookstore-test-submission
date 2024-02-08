package com.obsms.test.api.commons.exception.handler;


import com.obsms.test.api.commons.abs.AbstractBasicErrorHandler;
import com.obsms.test.api.commons.abs.IBasicErrorHandler;
import com.obsms.test.api.commons.abs.IErrorHandler;
import com.obsms.test.api.commons.exception.ErrorResponse;
import com.obsms.test.api.commons.exception.ErrorType;
import com.obsms.test.api.commons.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * {@link ControllerAdvice} for all {@link NotFoundException}.
 *
 * @author Ikram Samaad.
 * @see AbstractBasicErrorHandler
 * @see IBasicErrorHandler
 * @see IErrorHandler
 */
@ControllerAdvice
public class NotFoundExceptionHandler
        extends AbstractBasicErrorHandler<NotFoundException> {

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @Override
    public ResponseEntity<ErrorResponse> handler(NotFoundException ex) {
        ErrorResponse response =
                new ErrorResponse(ErrorType.NOT_FOUND.name(), ex.getMessage());
        logError(request, ex);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
