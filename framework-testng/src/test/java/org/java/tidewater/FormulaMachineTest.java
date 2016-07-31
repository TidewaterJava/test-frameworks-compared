package org.java.tidewater;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FormulaMachineTest {

  private FormulaMachine machine;

  @BeforeTest
  public void setup() {
    machine = new FormulaMachine();
  }

  @Test(dependsOnMethods = {"testDivideUpperLimit"})
  public void testDivide() {
    final Double result = machine.divide(10, 2);
    assertNotNull(result);
    assertEquals(5, result, 0);
  }

  @Test(expectedExceptions = {IllegalArgumentException.class})
  public void testDivideUpperLimit() {
    machine.divide(10000, 5);
    fail("Illegal argument exception should be thrown");
  }
}
