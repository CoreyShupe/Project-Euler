package com.github.coreyshupe.projecteuler;

import com.github.coreyshupe.projecteuler.exceptions.InvalidProblemClassException;
import com.github.coreyshupe.projecteuler.exceptions.InvalidProblemDefinitionException;
import com.github.coreyshupe.projecteuler.exceptions.UnsupportedProblemException;
import com.github.coreyshupe.projecteuler.p1to10.Problem1;
import com.github.coreyshupe.projecteuler.p1to10.Problem2;
import com.github.coreyshupe.projecteuler.p1to10.Problem3;
import com.github.coreyshupe.projecteuler.p1to10.Problem4;
import com.github.coreyshupe.projecteuler.p1to10.Problem5;
import java.util.Map;
import java.util.TreeMap;

public final class Main {

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

  public static void printProblem(int projectNumber, Problem<?> problem) {
    System.out.println("Project Number " + projectNumber);
    System.out.println("\tAnswer: " + problem.getSolution());
    System.out.println("\tSolution: in `" + problem.getClass().getName() + "`.");
  }

  private static Map<Integer, Problem<?>> registerProblems() {
    var map = new TreeMap<Integer, Problem<?>>(Integer::compareTo);
    try {
      registerProblem(Problem1.class, map);
      registerProblem(Problem2.class, map);
      registerProblem(Problem3.class, map);
      registerProblem(Problem4.class, map);
      registerProblem(Problem5.class, map);
    } catch (ReflectiveOperationException ex) {
      throw new RuntimeException(ex);
    }
    return map;
  }

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
