package com.obsms.test.api.commons.exception;

/**
 * @author Abdussamad
 */
public class BadRequestException extends WebServiceApiException {

  public BadRequestException(String message) {
    super(message);
  }
}
