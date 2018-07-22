package com.github.coreyshupe.projecteuler.p1to25;

import com.github.coreyshupe.projecteuler.Problem;
import com.github.coreyshupe.projecteuler.ProjectEulerProblem;

/**
 * To solve this problem, you must find the product of the values of the pythagorean triple which
 * has a sum of 1000.
 *
 * @see <a href="https://projecteuler.net/problem=9">Problem 9</a>
 */
@ProjectEulerProblem(9)
public class Problem9 implements Problem<Integer> {

  @Override
  public Integer getSolution() {
    int a = 1;
    int b;
    int c;
    for (; a < 334; a++) {
      for (b = a; b < (c = 1000 - a - b); b++) {
        if ((a * a) + (b * b) == c * c) {
          return a * b * c;
        }
      }
    }
    return 0;
  }
}
