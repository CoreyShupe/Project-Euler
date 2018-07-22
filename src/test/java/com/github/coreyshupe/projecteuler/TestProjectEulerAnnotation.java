package com.github.coreyshupe.projecteuler;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class TestProjectEulerAnnotation {

  @Test
  public void getProblemNumber_whenDefinedByAnnotation_shouldBeAccessible() {
    var annotation = WithAnnotation.class.getAnnotationsByType(ProjectEulerProblem.class)[0];
    Assertions.assertThat(annotation.value()).isEqualTo(5);
  }

  @Test
  public void getAnnotation_whenNotPresent_shouldHaveEmptyArray() {
    var annotations = WithoutAnnotation.class.getAnnotationsByType(ProjectEulerProblem.class);
    Assertions.assertThat(annotations.length).isEqualTo(0);
  }

  @ProjectEulerProblem(5)
  private final class WithAnnotation {}

  private final class WithoutAnnotation {}
}
