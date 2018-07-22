package com.github.coreyshupe.projecteuler.p1to25;

import com.github.coreyshupe.projecteuler.Problem;
import com.github.coreyshupe.projecteuler.ProjectEulerProblem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

/**
 * To solve this problem, you must find the 4 adjacent numbers in the same direction within the grid
 * making the largest product. <br>
 * The grid is given in (src/main/resources/p11grid.txt).
 *
 * @see <a href="https://projecteuler.net/problem=11">Problem 11</a>
 */
@ProjectEulerProblem(11)
public class Problem11 implements Problem<Integer> {

  @Override
  public Integer getSolution() {
    var grid = generatePopulatedGrid();
    int largest = 0;
    for (int y = 0; y < 20; y++) {
      for (int x = 0; x < 20; x++) {
        largest = Math.max(largest, retrieveLargestProductFromSet(grid, x, y));
      }
    }
    return largest;
  }

  /**
   * Finds all possible combinations from a specific location on the grid.
   *
   * @param grid The {@code int[][]} grid to search.
   * @param locationX X position of location.
   * @param locationY Y position of location.
   * @return The largest combination from the location in the grid.
   */
  public int retrieveLargestProductFromSet(int[][] grid, int locationX, int locationY) {
    int largest = 0;
    if (locationY <= 16) {
      // find down
      largest = grabDirectionInformation((i) -> grid[locationY + i][locationX], largest);
      if (locationX >= 3) {
        // find down left
        largest = grabDirectionInformation((i) -> grid[locationY + i][locationX - i], largest);
      }
      if (locationX <= 16) {
        // find down right
        largest = grabDirectionInformation((i) -> grid[locationY + i][locationX + i], largest);
      }
    }
    if (locationY >= 3) {
      // find up
      largest = grabDirectionInformation((i) -> grid[locationY - i][locationX], largest);
      if (locationX >= 3) {
        // find up left
        largest = grabDirectionInformation((i) -> grid[locationY - i][locationX - i], largest);
      }
      if (locationX <= 16) {
        // find up right
        largest = grabDirectionInformation((i) -> grid[locationY - i][locationX + i], largest);
      }
    }
    if (locationX <= 16) {
      // find right
      largest = grabDirectionInformation((i) -> grid[locationY][locationX + i], largest);
    }
    if (locationX >= 3) {
      // find left
      largest = grabDirectionInformation((i) -> grid[locationY][locationX - i], largest);
    }
    return largest;
  }

  /**
   * Generates values for the product using a {@link Function} to generate location information.
   * <br>
   * Once finding the value, compares it with the largest value and determines the final largest
   * value.
   *
   * @param retrievalFunction The {@link Function} to supply location values.
   * @param largest The largest current value of the algorithm.
   * @return The product.
   */
  public int grabDirectionInformation(Function<Integer, Integer> retrievalFunction, int largest) {
    int product = 1;
    for (int i = 0; i < 4; i++) {
      int value = retrievalFunction.apply(i);
      if (value == 0) {
        return 0;
      }
      product *= value;
    }
    return Math.max(largest, product);
  }

  /**
   * Generates a populated 20x20 grid in an {@code int[][]} based off
   * `src/main/resources/p11grid.txt`.
   *
   * @return The populated grid.
   */
  public int[][] generatePopulatedGrid() {
    var grid = new int[20][20];
    try (var reader =
        new BufferedReader(
            new InputStreamReader(Problem11.class.getResourceAsStream("/p11grid.txt")))) {
      String line;
      int placement = 0;
      while ((line = reader.readLine()) != null) {
        String[] values = line.split(" ");
        for (int i = 0; i < 20; i++) {
          grid[placement][i] = Integer.parseInt(values[i], 10);
        }
        placement++;
      }
    } catch (IOException ex) {
      throw new SecurityException(ex);
    }
    return grid;
  }
}
