package com.github.coreyshupe.projecteuler.p1to25;

import com.github.coreyshupe.projecteuler.Problem;
import com.github.coreyshupe.projecteuler.ProjectEulerProblem;

/**
 * To solve this problem, you must find the longest Collatz sequence under the initial value of 1
 * million.
 *
 * @see <a href="https://projecteuler.net/problem=14">Problem 14</a>
 */
@ProjectEulerProblem(14)
public class Problem14 implements Problem<Integer> {

  @Override
  public Integer getSolution() {
    int longest = 0;
    int number = 0;
    for (int i = 3; i < 1_000_000; i++) {
      if (!isPowerOfTwo(i)) {
        int count = generateCollatzSequenceNumberCount(i);
        if (count > longest) {
          number = i;
          longest = count;
        }
      }
    }
    return number;
  }

  /**
   * Generates the Collatz sequence of any given number.
   *
   * @param initial The initial number for the sequence.
   * @return The number of values in the sequence.
   * @see <a href="http://mathworld.wolfram.com/CollatzProblem.html">Collatz Problem</a>
   */
  private int generateCollatzSequenceNumberCount(int initial) {
    long value = initial;
    int count = 1;
    while (value != 1) {
      count++;
      if (value % 2 == 0) {
        value = value / 2;
      } else {
        value = (value * 3) + 1;
      }
    }
    return count;
  }

  /**
   * Checks if the number is a power of 2. Used to weed out very small Collatz sequences. Once a
   * number becomes a power of 2, the power of the 2 it is, will be the number of the sequence.
   *
   * @param numb The number to check.
   * @return True if the number is a power of 2.
   */
  private boolean isPowerOfTwo(int numb) {
    return numb != 0 && ((numb & (numb - 1)) == 0);
  }
}
