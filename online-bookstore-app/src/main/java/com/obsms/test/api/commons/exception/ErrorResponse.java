package com.obsms.test.api.commons.exception;


import com.obsms.test.api.commons.abs.AbstractResponseCode;

/**
 * @author Abdussamad
 */

public class ErrorResponse extends AbstractResponseCode {
    public ErrorResponse() {
    }

    public ErrorResponse(String code, String description) {
        super(code, description);
    }
}
