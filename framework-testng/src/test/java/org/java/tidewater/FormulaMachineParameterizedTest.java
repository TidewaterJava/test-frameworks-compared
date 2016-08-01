package org.java.tidewater;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FormulaMachineParameterizedTest {

  private FormulaMachine machine;

  @BeforeTest
  public void setup() {
    machine = new FormulaMachine(new BasicCalculator());
  }

  @DataProvider
  public Object[][] validDataProvider() {
    return new Object[][] {
        {1, 10, 0},
        {10, 10, 1},
        {20, 10, 2},
        {30, 10, 3},
        {40, 10, 4},
        {50, 10, 5},
        {60, 10, 6},
        {70, 10, 7},
        {80, 10, 8},
        {90, 10, 9},
        {100, 10, 10}};
  }

  @Test(dataProvider = "validDataProvider")
  public void testDivideWithParams(final int x, final int y, int expected) {
    final int result = machine.divide(x, y);
    assertEquals(expected, result);
  }
}
