package org.java.tidewater;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;

/**
 * From http://easymock.org/getting-started.html
 */
public class ExampleTest extends EasyMockSupport {

  private FormulaMachine machine;
  private CalculatorService calculator;

  @Before
  public void setUp() throws Exception {
    calculator = createNiceMock(CalculatorService.class);
    machine = new FormulaMachine(calculator);
  }

  @Test
  public void testCalculatorMocking() {
    // Setup the mock expectations
    expect(calculator.divide(1, 10)).andReturn(111);

    // Activate the mock
    replay(calculator);
    assertEquals(111, machine.divide(1, 10));
  }
}
