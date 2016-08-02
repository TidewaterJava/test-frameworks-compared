/*
 * Copyright 2015-2016 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.java.tidewater;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FormulaMachineParameterizedTest {

  private final int x;
  private final int y;
  private final int expected;

  public FormulaMachineParameterizedTest(int x, int y, int expected) {
    this.x = x;
    this.y = y;
    this.expected = expected;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> intData() {
    return Arrays.asList(new Object[][] {{1, 10, 0}, {2, 10, 0}, {3, 10, 0}, {10, 10, 1}});
  }

  @Test
  public void testGetFiboSeries() {
    final FormulaMachine macine = new FormulaMachine(new BasicCalculator());
    final int result = macine.divide(x, y);
    assertEquals(expected, result);
  }

}
