package com.obsms.test.api.commons.exception;

/**
 * @author Abdussamad
 */
public class ProcessingException extends WebServiceApiException {

  public ProcessingException(String message) {
    super(message);
  }

  public ProcessingException(Throwable cause) {
    super(cause);
  }
}
