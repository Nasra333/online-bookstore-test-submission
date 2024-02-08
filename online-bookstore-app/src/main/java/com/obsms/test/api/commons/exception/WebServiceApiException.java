package com.obsms.test.api.commons.exception;

/**
 * interface for application-specific web service api exceptions.
 *
 * @author Ikram Samaad
 * @see Exception
 */
public abstract class WebServiceApiException extends Exception {

    public WebServiceApiException(String message) {
        super(message);
    }

    public WebServiceApiException(Throwable cause) {
        super(cause);
    }
}
