package com.xinzodl.code.codeward

import org.scalatest.funsuite.AnyFunSuite

// https://www.codewars.com/kata/55eeddff3f64c954c2000059
class CW8_sumConsecutivesTest extends AnyFunSuite {

  test("Samples") {
    assert(CW8_sumConsecutives.sumConsecutives(List(1, 4, 4, 4, 0, 4, 3, 3, 1)) === List(1, 12, 0, 4, 6, 1))
    assert(CW8_sumConsecutives.sumConsecutives(List(1, 1, 7, 7, 3)) === List(2, 14, 3))
    assert(CW8_sumConsecutives.sumConsecutives(List(-5, -5, 7, 7, 12, 0)) === List(-10, 14, 12, 0))
    assert(CW8_sumConsecutives.sumConsecutives(List(3, 3, 3, 3, 1)) === List(12, 1))
  }
}