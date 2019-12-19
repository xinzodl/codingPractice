package com.xinzodl.code.codeward

import org.scalatest.flatspec.AnyFlatSpec

// https://www.codewars.com/kata/52f787eb172a8b4ae1000a34
class CW7_zerosTest extends AnyFlatSpec{
  it should "work with example tests" in {
    assert(CW7_zeros.zeros(0) == 0)
    assert(CW7_zeros.zeros(6) == 1)
    assert(CW7_zeros.zeros(14) == 2)
  }
}