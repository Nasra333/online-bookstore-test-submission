package com.obsms.test.api.commons.abs;

/**
 * abstract common base handler interface for error handling.
 *
 * @author Ikram Samaad.
 * @see IBasicErrorHandler
 * @see IErrorHandler
 */
public interface IErrorHandler<T extends Exception, R> {

    /**
     * Container error handling handler.
     *
     * @param ex
     * @return {@link R}
     */
    R handler(T ex);
}
