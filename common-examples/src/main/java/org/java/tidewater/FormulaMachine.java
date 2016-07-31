package org.java.tidewater;

import java.util.Objects;

public class FormulaMachine {
  public Double divide(Integer x, Integer y) {
    if (Objects.isNull(x) || Objects.isNull(y)) {
      return Double.valueOf(0);
    }

    if (x > 999) {
      throw new IllegalArgumentException("X should be less than 1000");
    }

    return (double) x / y;
  }

  public static String generateFileName() {
    return "results-" + System.currentTimeMillis() + ".txt";
  }
}
