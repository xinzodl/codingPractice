package com.xinzodl.code.codeward

import org.scalatest._
import org.scalatest.Assertions._

import CW1_digPowTest._

class CW1_digPowTest extends FlatSpec {
  it should "pass basic tests" in {
    testing(89, 1, 1)
    testing(92, 1, -1)
    testing(46288, 3, 51)

  }
}

object CW1_digPowTest {

  private def testing(n: Int, p: Int, expect: Int): Unit = {
    println("Testing: " + n + ", " + p)
    val actual: Int = CW1_digPow.digPow(n, p)
    println("Actual: " + actual)
    println("Expect: " + expect)
    println("*")
    assertResult(expect){actual}
  }
}
