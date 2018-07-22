package com.github.coreyshupe.projecteuler.p1to10;

import com.github.coreyshupe.projecteuler.MathUtils;
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
      if (MathUtils.isPrime(i)) {
        if (testable % i == 0) {
          output = i;
        }
      }
    }
    return output;
  }
}
