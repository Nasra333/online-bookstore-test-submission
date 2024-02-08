package com.obsms.test.api.commons.exception.handler;

import com.obsms.test.api.commons.abs.AbstractBasicErrorHandler;
import com.obsms.test.api.commons.abs.IBasicErrorHandler;
import com.obsms.test.api.commons.abs.IErrorHandler;
import com.obsms.test.api.commons.exception.ErrorResponse;
import com.obsms.test.api.commons.exception.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMapAdapter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * {@link ControllerAdvice} for all {@link Exception}s.
 *
 * @author Ikram Samaad.
 * @see AbstractBasicErrorHandler
 * @see IBasicErrorHandler
 * @see IErrorHandler
 */
@ControllerAdvice
public class AllExceptionHandler
        extends AbstractBasicErrorHandler<Exception> {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @Override
    public ResponseEntity<ErrorResponse> handler(Exception ex) {
        ErrorResponse response =
                new ErrorResponse(ErrorType.PROCESSING.name(), ex.getMessage());
        logError(request, ex);
        addTarget("content-type", MediaType.APPLICATION_JSON_VALUE);
        return new ResponseEntity<>(response, new MultiValueMapAdapter<>(targetMap), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public void addTarget(String key, String... values) {
        super.addTarget(key, values);
    }
}
