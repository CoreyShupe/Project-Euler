package com.github.coreyshupe.projecteuler.exceptions;

/**
 * The exception to be thrown when an inserted problem number cannot be parsed into a valid {@code
 * int}.
 */
public class InvalidProblemDefinitionException extends RuntimeException {

  public InvalidProblemDefinitionException(String message) {
    super(message);
  }
}
