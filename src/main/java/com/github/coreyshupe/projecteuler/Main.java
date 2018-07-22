package com.github.coreyshupe.projecteuler;

import com.github.coreyshupe.projecteuler.exceptions.InvalidProjectClassException;
import com.github.coreyshupe.projecteuler.exceptions.InvalidProjectDefinitionException;
import com.github.coreyshupe.projecteuler.exceptions.UnsupportedProjectException;
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
          throw new UnsupportedProjectException(
              "This problem has not yet been supported. If you'd like to add it see: ");
        }
      } else {
        throw new InvalidProjectDefinitionException(
            "Failed to understand the project # `" + rawProjectNumber + "`");
      }
    }
  }

  private static void printProblem(int projectNumber, Problem<?> problem) {
    System.out.println("Project Number " + projectNumber);
    System.out.println("\tAnswer: " + problem.getSolution());
    System.out.println("\tSolution: in `" + problem.getClass().getName() + "`.");
  }

  private static Map<Integer, Problem> registerProblems() {
    var map = new TreeMap<Integer, Problem>(Integer::compareTo);

    return map;
  }

  private static <I extends Problem> void registerProblem(
      Class<I> problemClazz, Map<Integer, Problem> map) throws ReflectiveOperationException {
    var annotations = problemClazz.getAnnotationsByType(ProjectEulerProblem.class);
    if (annotations.length == 0) {
      throw new InvalidProjectClassException(
          "The class `" + problemClazz.getName() + "` has not been annotated properly. ");
    }
    var annotation = annotations[0];
    map.put(annotation.value(), (Problem) problemClazz.getConstructors()[0].newInstance());
  }

  private Main() {}
}