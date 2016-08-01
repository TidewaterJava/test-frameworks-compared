package org.java.tidewater;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class FormulaMachineTest {

  private FormulaMachine machine;

  @Before
  public void setup() {
    final BasicCalculator calculator = new BasicCalculator();
    machine = new FormulaMachine(calculator);
  }

  @Test
  public void testDivide() {
    assertEquals(0, machine.divide(1, 10), 0);
    assertEquals(0, machine.divide(9, 10), 0);
    assertEquals(1, machine.divide(10, 10), 0);
    assertEquals(2, machine.divide(20, 10), 0);
    assertEquals(3, machine.divide(30, 10), 0);
    assertEquals(4, machine.divide(40, 10), 0);
    assertEquals(5, machine.divide(50, 10), 0);
    assertEquals(6, machine.divide(60, 10), 0);
    assertEquals(7, machine.divide(70, 10), 0);
    assertEquals(8, machine.divide(80, 10), 0);
    assertEquals(9, machine.divide(90, 10), 0);
    assertEquals(10, machine.divide(100, 10), 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDivideUpperLimit() {
    machine.divide(10000, 5);
    fail("Illegal argument exception should be thrown");
  }
}
