package com.obsms.test.api.commons.exception.handler;

import com.obsms.test.api.commons.abs.AbstractBasicErrorHandler;
import com.obsms.test.api.commons.abs.IBasicErrorHandler;
import com.obsms.test.api.commons.abs.IErrorHandler;
import com.obsms.test.api.commons.exception.AuthenticationException;
import com.obsms.test.api.commons.exception.ErrorResponse;
import com.obsms.test.api.commons.exception.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * {@link ControllerAdvice} for all {@link AuthenticationException}.
 *
 * @author Ikram Samaad.
 * @see AbstractBasicErrorHandler
 * @see IBasicErrorHandler
 * @see IErrorHandler
 */
@ControllerAdvice
public class AuthenticationExceptionHandler
        extends AbstractBasicErrorHandler<AuthenticationException> {

    @ResponseBody
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @Override
    public ResponseEntity<ErrorResponse> handler(AuthenticationException ex) {
        ErrorResponse response =
                new ErrorResponse(ErrorType.PERMISSION.name(), ex.getMessage());
        logError(request, ex);
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
}
