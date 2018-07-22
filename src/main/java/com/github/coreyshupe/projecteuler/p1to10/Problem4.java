package com.github.coreyshupe.projecteuler.p1to10;

import com.github.coreyshupe.projecteuler.Problem;
import com.github.coreyshupe.projecteuler.ProjectEulerProblem;

/**
 * To solve this problem, you must find the largest palindrome from the product of two three digit
 * numbers.
 *
 * @see <a href="https://projecteuler.net/problem=4">Problem 4</a>
 */
@ProjectEulerProblem(4)
public class Problem4 implements Problem<Integer> {

  @Override
  public Integer getSolution() {
    int latest = 0;
    int productX = 0;
    int productY = 0;
    outer:
    for (int x = 999; x > 100; x--) {
      for (int z = x; z > 100; z--) {
        int product = x * z;
        if (x < productX && x < productY && z < productX && z < productY) {
          break outer;
        }
        if (product > latest && isPalindrome(Integer.toString(product))) {
          latest = product;
          productX = x;
          productY = z;
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
    var builder = new StringBuilder(initial);
    return builder.reverse().toString().equals(initial);
  }
}
