package com.github.coreyshupe.projecteuler;

import com.github.coreyshupe.projecteuler.exceptions.InvalidProjectClassException;
import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestRegistration {

  private Map<Integer, Problem<?>> problemMap;

  @BeforeMethod
  public void generateMap() {
    problemMap = new HashMap<>();
  }

  @Test
  public void applyRegistration_whenAnnotationPresent_shouldRegister() {
    try {
      Main.registerProblem(ValidProblem.class, problemMap);
    } catch (ReflectiveOperationException ex) {
      Assertions.fail("Reflective operation exception thrown.");
    }
    Assertions.assertThat(problemMap).isNotEmpty().containsKey(5);
  }

  @Test
  public void applyRegistration_whenAnnotationNotPresent_shouldThrowError() {
    Assertions.assertThatThrownBy(() -> Main.registerProblem(InvalidProblem.class, problemMap))
        .isInstanceOf(InvalidProjectClassException.class);
  }

  @Test
  public void applyRegistration_whenClassInaccessible_shouldThrowError() {
    Assertions.assertThatThrownBy(() -> Main.registerProblem(PrivateProblem.class, problemMap))
        .isInstanceOf(ReflectiveOperationException.class);
  }

  @ProjectEulerProblem(5)
  public static class ValidProblem implements Problem<Integer> {
    @Override
    public Integer getSolution() {
      return 0;
    }
  }

  public static class InvalidProblem implements Problem<Integer> {
    @Override
    public Integer getSolution() {
      return 0;
    }
  }

  @ProjectEulerProblem(4)
  private static class PrivateProblem implements Problem<Integer> {
    @Override
    public Integer getSolution() {
      return 0;
    }
  }
}
