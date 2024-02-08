package com.obsms.test.api.commons.exception.handler;


import com.obsms.test.api.commons.abs.AbstractBasicErrorHandler;
import com.obsms.test.api.commons.abs.IBasicErrorHandler;
import com.obsms.test.api.commons.abs.IErrorHandler;
import com.obsms.test.api.commons.exception.ErrorResponse;
import com.obsms.test.api.commons.exception.ErrorType;
import com.obsms.test.api.commons.exception.ProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * {@link ControllerAdvice} for all {@link ProcessingException}.
 *
 * @author Ikram Samaad.
 * @see AbstractBasicErrorHandler
 * @see IBasicErrorHandler
 * @see IErrorHandler
 */
@ControllerAdvice
public class ProcessingExceptionHandler
        extends AbstractBasicErrorHandler<ProcessingException> {

    @ResponseBody
    @ExceptionHandler(ProcessingException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @Override
    public ResponseEntity<ErrorResponse> handler(ProcessingException ex) {
        ErrorResponse response =
                new ErrorResponse(ErrorType.PROCESSING.name(), ex.getMessage());
        logError(request, ex);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
