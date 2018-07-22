package com.github.coreyshupe.projecteuler.exceptions;

/**
 * The exception to be thrown when a {@link com.github.coreyshupe.projecteuler.Problem}'s class is
 * not built properly.
 */
public class InvalidProblemClassException extends RuntimeException {

  public InvalidProblemClassException(String message) {
    super(message);
  }
}
