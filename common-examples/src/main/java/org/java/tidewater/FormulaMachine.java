package org.java.tidewater;

public class FormulaMachine {
  private final CalculatorService calculator;

  public FormulaMachine(CalculatorService calculator) {
    this.calculator = calculator;
  }

  public int add(int x, int y) {
    return calculator.add(x, y);
  }

  public int subtract(int x, int y) {
    return calculator.subtract(x, y);
  }

  public int multiply(int x, int y) {
    return calculator.multiply(x, y);
  }

  public int divide(int x, int y) {
    if (y == 0) {
      throw new IllegalArgumentException("Cannot divide by zero");
    }

    return calculator.divide(x, y);
  }

  public static String generateFileName() {
    return "results-" + System.currentTimeMillis() + ".txt";
  }
}
