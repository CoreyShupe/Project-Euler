package com.github.coreyshupe.projecteuler;

import com.github.coreyshupe.projecteuler.exceptions.InvalidProblemClassException;
import com.github.coreyshupe.projecteuler.exceptions.InvalidProblemDefinitionException;
import com.github.coreyshupe.projecteuler.exceptions.UnsupportedProblemException;
import com.github.coreyshupe.projecteuler.p1to25.Problem1;
import com.github.coreyshupe.projecteuler.p1to25.Problem10;
import com.github.coreyshupe.projecteuler.p1to25.Problem11;
import com.github.coreyshupe.projecteuler.p1to25.Problem2;
import com.github.coreyshupe.projecteuler.p1to25.Problem3;
import com.github.coreyshupe.projecteuler.p1to25.Problem4;
import com.github.coreyshupe.projecteuler.p1to25.Problem5;
import com.github.coreyshupe.projecteuler.p1to25.Problem6;
import com.github.coreyshupe.projecteuler.p1to25.Problem7;
import com.github.coreyshupe.projecteuler.p1to25.Problem8;
import com.github.coreyshupe.projecteuler.p1to25.Problem9;
import java.util.Map;
import java.util.TreeMap;

/** The main entry {@code class} for the program. */
public final class Main {

  /**
   * The main entry point for the program.
   *
   * @param args The execution parameters.
   */
  public static void main(String[] args) {
    var problems = registerProblems();
    if (args.length == 0) {
      problems.forEach(Main::printProblem);
    } else {
      var rawProjectNumber = args[0];
      if (rawProjectNumber.matches("\\d+")) {
        var projectNumber = Integer.parseInt(rawProjectNumber);
        if (problems.containsKey(projectNumber)) {
          printProblem(projectNumber, problems.get(projectNumber));
        } else {
          throw new UnsupportedProblemException(
              "This problem has not yet been supported. If you'd like to add it see: ");
        }
      } else {
        throw new InvalidProblemDefinitionException(
            "Failed to understand the project # `" + rawProjectNumber + "`");
      }
    }
  }

  /**
   * Prints out the details for a specified {@link Problem}. <br>
   * Includes the problem number along with the answer and solution {@code class} location.
   *
   * @param problemNumber The number of the problem.
   * @param problem The {@link Problem}.
   */
  public static void printProblem(int problemNumber, Problem<?> problem) {
    System.out.println("Project Number " + problemNumber);
    System.out.println("\tAnswer: " + problem.getSolution());
    System.out.println("\tSolution: in `" + problem.getClass().getName() + "`.");
  }

  /**
   * Retrieves all defined problems in the project.
   *
   * @return The {@link Map} containing the problem numbers matched with their {@link Problem}.
   */
  private static Map<Integer, Problem<?>> registerProblems() {
    var map = new TreeMap<Integer, Problem<?>>(Integer::compareTo);
    try {
      registerProblem(Problem1.class, map);
      registerProblem(Problem2.class, map);
      registerProblem(Problem3.class, map);
      registerProblem(Problem4.class, map);
      registerProblem(Problem5.class, map);
      registerProblem(Problem6.class, map);
      registerProblem(Problem7.class, map);
      registerProblem(Problem8.class, map);
      registerProblem(Problem9.class, map);
      registerProblem(Problem10.class, map);
      registerProblem(Problem11.class, map);
    } catch (ReflectiveOperationException ex) {
      throw new RuntimeException(ex);
    }
    return map;
  }

  /**
   * Registers a problem to a class.
   *
   * @param problemClazz The {@link I}'s {@link Class} for building.
   * @param map The {@link Map} which the problem should be added to.
   * @param <I> The type class of problem.
   * @throws ReflectiveOperationException When the {@link Class} is not accessible.
   */
  public static <I extends Problem<?>> void registerProblem(
      Class<I> problemClazz, Map<Integer, Problem<?>> map) throws ReflectiveOperationException {
    var annotations = problemClazz.getAnnotationsByType(ProjectEulerProblem.class);
    if (annotations.length == 0) {
      throw new InvalidProblemClassException(
          "The class `" + problemClazz.getName() + "` has not been annotated properly. ");
    }
    var annotation = annotations[0];
    map.put(annotation.value(), problemClazz.getConstructor().newInstance());
  }

  private Main() {}
}
