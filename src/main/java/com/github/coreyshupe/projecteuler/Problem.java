package com.github.coreyshupe.projecteuler;

/**
 * Defined for the problem hierarchy. Gives implementation for all required methods for problems.
 *
 * @param <I> The return value of the problem.
 */
@FunctionalInterface
public interface Problem<I> {

  /**
   * Used to get the solution to a problem.
   *
   * @return The solution of the problem.
   */
  I getSolution();
}
