package com.obsms.test.api.commons.abs;

import com.obsms.test.api.commons.exception.ErrorResponse;
import org.springframework.http.ResponseEntity;

/**
 * abstract interface handler for {@link ResponseEntity} {@link ErrorResponse}.
 *
 * @author Ikram Samaad.
 * @see IErrorHandler
 * @see ResponseEntity
 */
public interface IBasicErrorHandler<T extends Exception>
        extends IErrorHandler<T, ResponseEntity<ErrorResponse>> {

    /**
     * @param ex
     * @return {@link ResponseEntity}
     */
    @Override
    ResponseEntity<ErrorResponse> handler(T ex);
}
