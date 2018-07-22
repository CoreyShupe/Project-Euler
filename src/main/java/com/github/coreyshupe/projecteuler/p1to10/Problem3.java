package com.github.coreyshupe.projecteuler.p1to10;

import com.github.coreyshupe.projecteuler.Problem;
import com.github.coreyshupe.projecteuler.ProjectEulerProblem;

/**
 * To solve this problem, you must find the largest prime of 600851475143.
 *
 * @see <a href="https://projecteuler.net/problem=2">Problem 3</a>
 */
@ProjectEulerProblem(3)
public class Problem3 implements Problem<Long> {

  @Override
  public Long getSolution() {
    long testable = 600_851_475_143L;
    long output = -1;
    for (long i = 3; i * i < testable; i += 2) {
      if (isPrime(i)) {
        if (testable % i == 0) {
          output = i;
        }
      }
    }
    return output;
  }

  /**
   * Simple prime test. <br>
   * Starting at 3 (all numbers coming in have the precondition of not being divisible by 2). <br>
   * We add 2 to each only getting odds, checking if n is divisible by it, if so it cannot be prime.
   * <br>
   * Checking if i squared is less than n to stop unnecessary checking of higher numbers.
   *
   * @param n The number to check if prime.
   * @return if the variable n is prime.
   */
  private boolean isPrime(long n) {
    for (long i = 3; i * i < n; i += 2) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
