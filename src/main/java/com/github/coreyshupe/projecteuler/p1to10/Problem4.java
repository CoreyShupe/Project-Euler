package com.github.coreyshupe.projecteuler.p1to10;

import com.github.coreyshupe.projecteuler.Problem;
import com.github.coreyshupe.projecteuler.ProjectEulerProblem;

/**
 * To solve this problem, you must find the largest palindrome from the product of two three digit
 * numbers.
 *
 * <p><a href="https://projecteuler.net/problem=4">Problem 4</a>
 */
@ProjectEulerProblem(4)
public class Problem4 implements Problem<Integer> {

  @Override
  public Integer getSolution() {
    int latest = 0;
    for (int x = 999; x > 100; x--) {
      for (int z = 999; z > 100; z--) {
        int product = x * z;
        if (product > latest && isPalindrome(Integer.toString(product))) {
          latest = product;
        }
      }
    }
    return latest;
  }

  /**
   * Checks if a {@link String} is a palindrome. <br>
   * Here we take a {@link String} and put it into a {@link StringBuilder}, reverse the {@link
   * StringBuilder}, and check if the outputs match.
   *
   * @param initial The initial {@link String} to check if it's a palindrome.
   * @return True if the initial input is a palindrome.
   */
  private boolean isPalindrome(String initial) {
    StringBuilder builder = new StringBuilder(initial);
    builder.reverse();
    return builder.toString().equals(initial);
  }
}
