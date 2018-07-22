package com.github.coreyshupe.projecteuler.p1to25;

import com.github.coreyshupe.projecteuler.MathUtils;
import com.github.coreyshupe.projecteuler.Problem;
import com.github.coreyshupe.projecteuler.ProjectEulerProblem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * To solve this problem, you must find the first ten digits of the sum of the 100 50 digit numbers.
 * <br>
 * The numbers are given in the text file in (src/main/resources/p13numbers.txt).
 *
 * @see <a href="https://projecteuler.net/problem=13">Problem 13</a>
 */
@ProjectEulerProblem(13)
public class Problem13 implements Problem<String> {

  @Override
  public String getSolution() {
    String value;
    try (var reader =
        new BufferedReader(
            new InputStreamReader(Problem13.class.getResourceAsStream("/p13numbers.txt")))) {
      value = reader.readLine();
      for (String next; (next = reader.readLine()) != null; ) {
        value = simplyAdd(value, next);
      }
    } catch (IOException ex) {
      throw new SecurityException(ex);
    }
    return value.substring(0, 10);
  }

  /**
   * Simply adds 2 {@link String}s together to make a large number.
   *
   * @param initial The initial number as a {@link String}.
   * @param additive The adding number as a {@link String}.
   * @return The added {@link String}.
   */
  public String simplyAdd(String initial, String additive) {
    var reversedInitial = new StringBuilder(initial).reverse().toString();
    var reversedAdditive = new StringBuilder(additive).reverse().toString();
    var initChars = reversedInitial.toCharArray();
    var additiveChars = reversedAdditive.toCharArray();
    var newNumber = new ArrayList<Character>();
    int leftover = 0;
    int stopped = 0;
    for (int i = 0; i < additiveChars.length; i++) {
      int iDigit = MathUtils.getDigit(initChars[i]);
      int aDigit = MathUtils.getDigit(additiveChars[i]);
      int processed = iDigit + aDigit + leftover;
      newNumber.add(Character.forDigit(processed % 10, 10));
      leftover = processed / 10;
      stopped = i + 1;
    }
    while (leftover > 0) {
      if (initChars.length <= stopped) {
        if (leftover >= 10) {
          var chars =
              new StringBuilder(Integer.toString(leftover, 10)).reverse().toString().toCharArray();
          for (char c : chars) {
            newNumber.add(c);
          }
          break;
        }
        newNumber.add(Character.forDigit(leftover, 10));
        break;
      }
      int curr = MathUtils.getDigit(initChars[stopped]);
      curr = leftover + curr;
      leftover = curr / 10;
      newNumber.add(Character.forDigit(curr % 10, 10));
      stopped++;
    }
    while (stopped < initChars.length) {
      newNumber.add(initChars[stopped]);
      stopped++;
    }
    var numbBuilder = new StringBuilder();
    newNumber.forEach(numbBuilder::append);
    return numbBuilder.reverse().toString();
  }
}
