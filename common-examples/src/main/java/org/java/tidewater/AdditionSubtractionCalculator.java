package org.java.tidewater;

public class AdditionSubtractionCalculator implements CalculatorService {

  @Override
  public int add(int x, int y) {
    return Math.addExact(x, y);
  }

  @Override
  public int subtract(int x, int y) {
    return Math.subtractExact(x, y);
  }

  @Override
  public int multiply(int x, int y) {
    int sum = 0;
    for (int counter = 0; counter < y; counter++) {
      sum = add(sum, x);
    }

    return sum;
  }

  @Override
  public int divide(int x, int y) {
    int sum = x;
    int counter = 0;
    while (sum >= y) {
      sum = subtract(sum, y);
      counter++;
    }

    return counter;
  }

}
