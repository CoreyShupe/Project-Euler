package com.github.coreyshupe.projecteuler.p1to25;

import com.github.coreyshupe.projecteuler.Problem;
import com.github.coreyshupe.projecteuler.ProjectEulerProblem;

/**
 * To solve this problem, you must find the first triangle number to contain over five hundred
 * divisors.
 *
 * @see <a href="https://projecteuler.net/problem=12">Problem 12</a>
 */
@ProjectEulerProblem(12)
public class Problem12 implements Problem<Integer> {

  @Override
  public Integer getSolution() {
    int latestNumb = 1;
    for (int i = 2; ; i++) {
      latestNumb += i;
      int divisors = retrieveNumberOfDivisors(latestNumb);
      if (divisors > 500) {
        return latestNumb;
      }
    }
  }

  /**
   * Retrieves the number of divisors from a given number.
   *
   * @param number The number to check for divisors.
   * @return The number of divisors of the given number.
   */
  public int retrieveNumberOfDivisors(int number) {
    int divisors = 2;
    int additive = 1;
    if (number % 2 != 0) {
      divisors--;
      additive = 2;
    }
    for (int i = 3; i * i < number; i += additive) {
      if (number % i == 0) {
        divisors += 2;
      }
    }
    return divisors;
  }
}
