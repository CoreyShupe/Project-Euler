package com.github.coreyshupe.projecteuler;

@FunctionalInterface
public interface Problem<I> {

  I getSolution();
}
