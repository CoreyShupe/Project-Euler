package com.github.coreyshupe.projecteuler;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class TestSanity {

  @Test
  public void testSanity() {
    Assertions.assertThat(true).isTrue();
  }
}
