package com.github.coreyshupe.projecteuler.p1to10;

import com.github.coreyshupe.projecteuler.Problem;
import com.github.coreyshupe.projecteuler.ProjectEulerProblem;

/**
 * To solve this problem, you must find the smallest positive which 1-20 divides into cleanly.
 *
 * <p><a href="https://projecteuler.net/problem=5">Problem 5</a>
 */
@ProjectEulerProblem(5)
public class Problem5 implements Problem<Integer> {

  @Override
  public Integer getSolution() {
    initial:
    for (int x = 20; ; x += 20) {
      for (int z = 3; z < 20; z++) {
        if (x % z != 0) {
          continue initial;
        }
      }
      return x;
    }
  }
}
