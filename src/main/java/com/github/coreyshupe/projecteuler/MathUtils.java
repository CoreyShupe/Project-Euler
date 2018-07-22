package com.github.coreyshupe.projecteuler;

/** Some simple math utilities to work with the {@link Problem}s. */
public final class MathUtils {

  /**
   * Simple prime test. <br>
   * Starting at 3 (all numbers coming in have the precondition of not being divisible by 2). <br>
   * We add 2 to each only getting odds, checking if n is divisible by it, if so it cannot be prime.
   * <br>
   * Checking if i squared is less than n to stop unnecessary checking of higher numbers. <br>
   * Any number between 0-3 are always prime.
   *
   * @param n The number to check if prime.
   * @return if the variable n is prime.
   */
  public static boolean isPrime(long n) {
    if (n < 0) {
      n = -n;
    }
    if (n <= 3) {
      return true;
    }
    if (n % 2 == 0) {
      return false;
    }
    for (long i = 3; i * i <= n; i += 2) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Turns the {@code char} into a base10 {@code int}.
   *
   * @param c The {@code char} to turn into the {@code int}.
   * @return The {@code int} form of {@code c}.
   */
  public static int getDigit(char c) {
    return Character.digit(c, 10);
  }

  private MathUtils() {}
}
