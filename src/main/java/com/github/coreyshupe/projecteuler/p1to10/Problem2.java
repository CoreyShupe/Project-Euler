package com.github.coreyshupe.projecteuler.p1to10;

import com.github.coreyshupe.projecteuler.Problem;
import com.github.coreyshupe.projecteuler.ProjectEulerProblem;

/**
 * To solve this problem, you must find the sum of all even numbers in the Fibonacci sequence under
 * the value of 4 million.
 *
 * @see <a href="https://projecteuler.net/problem=2">Problem 2</a>
 */
@ProjectEulerProblem(2)
public class Problem2 implements Problem<Integer> {

  @Override
  public Integer getSolution() {
    int sum = 0;
    for (int x = 0, z = 1, temp; z < 4_000_000; temp = z, z = z + x, x = temp) {
      if (z % 2 == 0) {
        sum += z;
      }
    }
    return sum;
  }
}
