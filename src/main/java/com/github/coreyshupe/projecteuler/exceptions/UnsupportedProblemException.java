package com.github.coreyshupe.projecteuler.exceptions;

/**
 * The exception to be thrown when a problem is currently not supported in the current
 * registrations.
 */
public class UnsupportedProblemException extends RuntimeException {

  public UnsupportedProblemException(String message) {
    super(message);
  }
}
