package org.java.tidewater;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class FormulaMachineMockTest {

  @Mock
  CalculatorService calculator;

  @InjectMocks
  private FormulaMachine machine;

  @Before
  public void initMocks() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testDivide() {
    when(calculator.divide(eq(1), anyInt())).thenReturn(99);

    // We know this is wrong, we just want to show what happens when the mock matches
    assertEquals(99, machine.divide(1, 10));
    assertEquals(99, machine.divide(1, 100));

    // We know this is wrong, we just want to show the default result of the mock is 0
    assertEquals(0, machine.divide(20, 10));
  }

  @Test(expected = ArithmeticException.class)
  public void testDivideWithZero() {
    when(calculator.divide(anyInt(), anyInt()))
        .thenThrow(new ArithmeticException("Exception the service could throw"));

    machine.divide(1, 10);
    fail("Exception should be thrown by mock");
  }
}
