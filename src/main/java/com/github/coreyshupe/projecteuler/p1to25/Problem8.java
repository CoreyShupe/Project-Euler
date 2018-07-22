package com.github.coreyshupe.projecteuler.p1to25;

import com.github.coreyshupe.projecteuler.MathUtils;
import com.github.coreyshupe.projecteuler.Problem;
import com.github.coreyshupe.projecteuler.ProjectEulerProblem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * To solve this problem, you must find the 13 consecutive numbers which lead to the largest
 * product. <br>
 * The number to search through is in (src/main/resources/p8number.txt).
 *
 * @see <a href="https://projecteuler.net/problem=8">Problem 8</a>
 */
@ProjectEulerProblem(8)
public class Problem8 implements Problem<Long> {

  /** The constant {@code int} representing the amount of digits to consecutively multiply. */
  private static final int CONSECUTIVE_NUMBS = 13;

  @Override
  public Long getSolution() {
    var numbBuilder = new StringBuilder();
    try (var reader =
        new BufferedReader(
            new InputStreamReader(Problem8.class.getResourceAsStream("/p8number.txt")))) {
      for (String line; (line = reader.readLine()) != null; ) {
        numbBuilder.append(line);
      }
    } catch (IOException ex) {
      throw new SecurityException(ex);
    }
    var numb = numbBuilder.toString();
    var chars = numb.toCharArray();
    long largestProduct = 1;
    long currentProduct;
    var queue = new ArrayDeque<Integer>();
    for (int i = 0; i < CONSECUTIVE_NUMBS; i++) {
      int digit = MathUtils.getDigit(chars[i]);
      largestProduct *= digit;
      queue.offerLast(digit);
    }
    currentProduct = largestProduct;
    outer:
    for (int i = CONSECUTIVE_NUMBS; i < chars.length; i++) {
      int digit = MathUtils.getDigit(chars[i]);
      if (digit == 0) {
        queue.clear();
        currentProduct = 1;
        i++;
        for (; queue.size() < CONSECUTIVE_NUMBS; i++) {
          if (i == chars.length) {
            break outer;
          }
          digit = MathUtils.getDigit(chars[i]);
          if (digit == 0) {
            queue.clear();
            currentProduct = 1;
            continue;
          }
          currentProduct *= digit;
          queue.offerLast(digit);
        }
        if (currentProduct > largestProduct) {
          largestProduct = currentProduct;
        }
        i--;
        continue;
      }
      Integer last = queue.poll();
      if (last == null) {
        throw new SecurityException("Something went wrong with i value " + i + ".");
      }
      currentProduct /= last;
      currentProduct *= digit;
      queue.offerLast(digit);
      if (currentProduct > largestProduct) {
        largestProduct = currentProduct;
      }
    }
    return largestProduct;
  }
}
