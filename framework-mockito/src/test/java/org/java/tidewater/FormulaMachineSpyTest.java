package org.java.tidewater;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class FormulaMachineSpyTest {

  @Spy
  CalculatorService calculator = new BasicCalculator();

  @InjectMocks
  private FormulaMachine machine;

  @Before
  public void initMocks() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testDivide() {
    assertEquals(0, machine.divide(1, 10));

    verify(calculator, only()).divide(eq(1), eq(10));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDivideWithZero() {
    machine.divide(1000, 0);

    verifyZeroInteractions(calculator);
  }
}
