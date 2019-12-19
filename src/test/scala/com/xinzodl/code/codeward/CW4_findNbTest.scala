package com.xinzodl.code.codeward

import org.scalatest.funsuite.AnyFunSuite

// https://www.codewars.com/kata/5592e3bd57b64d00f3000047
class CW4_findNbTest extends AnyFunSuite {

  test("Samples") {
    assert(CW4_findNb.findNb(4183059834009L)   === 2022)
    assert(CW4_findNb.findNb(24723578342962L)  === -1)
    assert(CW4_findNb.findNb(135440716410000L) === 4824)
    assert(CW4_findNb.findNb(40539911473216L)  === 3568)
    assert(CW4_findNb.findNb(26825883955641L)  === 3218)
  }
}