package org.java.tidewater;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FormulaMachineParameterizedTest {

  private FormulaMachine machine;

  @BeforeTest
  public void setup() {
    machine = new FormulaMachine();
  }

  @DataProvider
  public Object[][] validDataProvider() {
    return new Object[][] {
        {1, 10, 0.1},
        {2, 10, 0.2},
        {3, 10, 0.3},
        {4, 10, 0.4},
        {5, 10, 0.5},
        {6, 10, 0.6},
        {7, 10, 0.7},
        {8, 10, 0.8},
        {9, 10, 0.9},
        {10, 10, 1.0}};
  }

  @Test(dataProvider = "validDataProvider")
  public void testDivideWithParams(final int x, final int y, double expected) {

    final Double result = machine.divide(x, y);
    assertEquals(expected, result, 0);
  }
}
