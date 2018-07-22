package com.github.coreyshupe.projecteuler;

import com.github.coreyshupe.projecteuler.exceptions.InvalidProblemDefinitionException;
import com.github.coreyshupe.projecteuler.exceptions.UnsupportedProblemException;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class TestMain {

  @Test
  public void runMain_whenNonNumberArgument_shouldThrowException() {
    Assertions.assertThatThrownBy(() -> Main.main(new String[] {"test"}))
        .isInstanceOf(InvalidProblemDefinitionException.class);
  }

  @Test
  public void runMain_whenInvalidProjectNumber_shouldThrowException() {
    Assertions.assertThatThrownBy(() -> Main.main(new String[] {"0"}))
        .isInstanceOf(UnsupportedProblemException.class);
  }
}
