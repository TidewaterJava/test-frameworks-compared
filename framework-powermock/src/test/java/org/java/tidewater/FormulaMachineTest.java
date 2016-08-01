package org.java.tidewater;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FormulaMachine.class)
public class FormulaMachineTest {

  @Test
  public void testFilenameStuff() throws Exception {
    mockStatic(System.class);
    when(System.currentTimeMillis()).thenReturn(1L);

    assertEquals("results-1.txt", FormulaMachine.generateFileName());
  }
}
