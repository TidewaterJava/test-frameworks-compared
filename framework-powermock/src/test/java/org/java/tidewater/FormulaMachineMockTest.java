package org.java.tidewater;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({AdditionSubtractionCalculator.class})
public class FormulaMachineMockTest {

  private FormulaMachine machine;
  final CalculatorService calculator = new AdditionSubtractionCalculator();

  @Before
  public void setup() {
    machine = new FormulaMachine(calculator);
  }

  @Test
  public void testMockingStaticCalls() throws Exception {
    mockStatic(Math.class);
    when(Math.subtractExact(anyInt(), anyInt())).thenReturn(0);

    assertEquals(1, machine.divide(100, 10));
  }

  @Test
  public void testVerifyingStaticCalls() {
    spy(Math.class);

    assertEquals(10, machine.divide(100, 10));

    verifyStatic(times(10));
    Math.subtractExact(anyInt(), anyInt());

    verifyStatic(times(0));
    Math.addExact(anyInt(), anyInt());
  }
}
