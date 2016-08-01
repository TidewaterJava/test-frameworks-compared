package org.java.tidewater;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FormulaMachineTest {

  private FormulaMachine machine;

  @Before
  public void setup() {
    machine = new FormulaMachine(new BasicCalculator());
  }

  @Test
  public void testDivide() {
    assertThat(machine.divide(1, 10), is(0.1));
    assertThat(machine.divide(1, 10), greaterThanOrEqualTo(0));
    assertThat(machine.divide(1, 10), lessThan(1));
    assertThat("Testing immutability of result", machine.divide(1, 10), not(sameInstance(0.1)));
    assertThat(machine.divide(1, 10), is(equalTo(0.1)));
  }
}
