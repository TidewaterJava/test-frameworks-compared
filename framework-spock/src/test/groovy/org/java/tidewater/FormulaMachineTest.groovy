package org.java.tidewater

import spock.lang.Shared
import spock.lang.Specification


class FormulaMachineTest extends Specification {

  def @Shared machine = new FormulaMachine();

  def "divide by null returns zero"() {
    setup:
    Integer nullInteger = null

    when:
    def result = machine.divide(nullInteger, 5);

    then:
    result == 0
  }

  def "divide test divisor upper limit"() {
    when:
    machine.divide(10000, 5);

    then:
    thrown IllegalArgumentException
  }

  //  @Unroll
  def "parameterized test of the Formula Machine"() {
    expect:
    machine.divide(x, y) == expected

    where:
    x    | y    || expected
    1    | 10   || 0.1
    2    | 10   || 0.2
    3    | 10   || 0.3
    4    | 10   || 0.4
    5    | 10   || 0.5
    6    | 10   || 0.6
    7    | 10   || 0.7
    8    | 10   || 0.8
    9    | 10   || 0.9
    10   | 10   || 1.0
  }
}
