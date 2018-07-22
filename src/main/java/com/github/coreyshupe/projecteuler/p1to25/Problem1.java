package com.github.coreyshupe.projecteuler.p1to25;

import com.github.coreyshupe.projecteuler.Problem;
import com.github.coreyshupe.projecteuler.ProjectEulerProblem;

/**
 * To solve this problem, you must find the sum of all numbers below 1000 of the multiples 3 or 5.
 *
 * @see <a href="https://projecteuler.net/problem=1">Problem 1</a>
 */
@ProjectEulerProblem(1)
public class Problem1 implements Problem<Integer> {

  @Override
  public Integer getSolution() {
    int sum = 0;
    for (int i = 0; i < 1000; i++) {
      if (i % 3 == 0 || i % 5 == 0) {
        sum += i;
      }
    }
    return sum;
  }
}
