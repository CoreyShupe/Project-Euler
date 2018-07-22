package com.github.coreyshupe.projecteuler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** The {@code @interface} which defines a class as a Project-Euler problem. */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ProjectEulerProblem {
  /**
   * Represents the defined problem's number as an {@code int}.
   *
   * @return The problem number.
   */
  int value();
}
