package org.java.tidewater;

import static org.easymock.EasyMock.anyInt;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(EasyMockRunner.class)
public class FormulaMachineTest {

  @TestSubject
  private final FormulaMachine machine = new FormulaMachine();

  @Mock
  private CalculatorService calculator;

  @Test
  public void testCalculatorMocking() {
    // Setup the mock expectations
    expect(calculator.divide(anyInt(), anyInt())).andReturn(111);
    // expect(calculator.divide(10, 10)).andReturn(111).atLeastOnce();

    // Activate the mock
    replay(calculator);
    assertEquals(111, machine.divide(1, 10));

    verify(calculator);
  }
}
