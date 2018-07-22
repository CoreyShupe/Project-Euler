package com.github.coreyshupe.projecteuler.p1to25;

import com.github.coreyshupe.projecteuler.Problem;
import com.github.coreyshupe.projecteuler.ProjectEulerProblem;

/**
 * To solve this problem, you must find the difference between the sum of the squares of the first
 * one hundred natural numbers and the square of the sums.
 *
 * @see <a href="https://projecteuler.net/problem=6">Problem 6</a>
 */
@ProjectEulerProblem(6)
public class Problem6 implements Problem<Integer> {

  @Override
  public Integer getSolution() {
    int squaredSums = 0;
    int additive = 0;
    for (int i = 1; i < 101; i++) {
      squaredSums += i * i;
      additive += i;
    }
    return (additive * additive) - squaredSums;
  }
}
