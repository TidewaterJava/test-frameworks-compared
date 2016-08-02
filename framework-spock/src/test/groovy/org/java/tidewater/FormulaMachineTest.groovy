package org.java.tidewater
import static spock.lang.MockingApi.Spy
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll


class FormulaMachineTest extends Specification {

  def @Shared calculator = new BasicCalculator();
  def @Shared machine = new FormulaMachine(calculator);

  def "test divide by zero"() {
    when:
    machine.divide(10000, 0);

    then:
    thrown IllegalArgumentException
  }

  @Unroll
  def "parameterized test of the Formula Machine"() {
    expect:
    machine.divide(x, y) == expected

    where:
    x    | y    || expected
    1    | 10   || 0
    2    | 10   || 0
    3    | 10   || 0
    4    | 10   || 0
    5    | 10   || 0
    6    | 10   || 0
    7    | 10   || 0
    8    | 10   || 0
    9    | 10   || 0
    10   | 10   || 1
  }

  def "spy on calculator calls (overwrites the bytecode *scary*)"() {
    setup:
    def calculator = Spy(AdditionSubtractionCalculator)
    def machine = new FormulaMachine(calculator)

    when:
    machine.divide(100, 10);

    then:
    10 * calculator.subtract(_, _)
  }

  def "mock calculator calls"() {
    setup:
    def calculator = Mock(CalculatorService)
    def machine = new FormulaMachine(calculator)

    when:
    int result = machine.divide(100, 10);

    then:
    result == 0
    1 * calculator.divide(_, _)
  }

  def "stub calculator calls"() {
    setup:
    def calculator = Stub(CalculatorService) {
      divide(_, _) >> 27
    }
    def machine = new FormulaMachine(calculator)

    when:
    int result = machine.divide(100, 10);

    then:
    result == 27
  }
}
