package org.java.tidewater;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class FormulaMachineTest {

  private FormulaMachine machine;

  @Before
  public void setup() {
    machine = new FormulaMachine();
  }

  @Test
  public void testDivide() {
    assertEquals(0.1, machine.divide(1, 10), 0);
    assertEquals(0.2, machine.divide(2, 10), 0);
    assertEquals(0.3, machine.divide(3, 10), 0);
    assertEquals(0.4, machine.divide(4, 10), 0);
    assertEquals(0.5, machine.divide(5, 10), 0);
    assertEquals(0.6, machine.divide(6, 10), 0);
    assertEquals(0.7, machine.divide(7, 10), 0);
    assertEquals(0.8, machine.divide(8, 10), 0);
    assertEquals(0.9, machine.divide(9, 10), 0);
    assertEquals(1.0, machine.divide(10, 10), 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDivideUpperLimit() {
    machine.divide(10000, 5);
    fail("Illegal argument exception should be thrown");
  }
}
