package com.github.coreyshupe.projecteuler.p1to25;

import com.github.coreyshupe.projecteuler.MathUtils;
import com.github.coreyshupe.projecteuler.Problem;
import com.github.coreyshupe.projecteuler.ProjectEulerProblem;

/**
 * To solve this problem, you must find the 10,001st prime number.
 *
 * @see <a href="https://projecteuler.net/problem=7">https://projecteuler.net/problem=7</a>
 */
@ProjectEulerProblem(7)
public class Problem7 implements Problem<Long> {

  @Override
  public Long getSolution() {
    long lastPrime = 2;
    for (int primesFound = 1, i = 3; primesFound != 10001; i += 2) {
      if (MathUtils.isPrime(i)) {
        primesFound++;
        lastPrime = i;
      }
    }
    return lastPrime;
  }
}
