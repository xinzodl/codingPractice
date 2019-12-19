package com.xinzodl.code.codeward

import org.scalatest._
import org.scalatest.Assertions._

import CW5_CommonDenominatorsTest._

// https://www.codewars.com/kata/54d7660d2daf68c619000d95
class CW5_CommonDenominatorsTest extends FlatSpec {
  it should "pass basic tests" in {
    var lst: Array[(Long, Long)]  = Array((1, 2), (1, 3), (1, 4))
    testing(lst, "(6,12)(4,12)(3,12)")

    lst = Array((69, 130), (87, 1310), (30, 40))
    testing(lst, "(18078,34060)(2262,34060)(25545,34060)")

    lst = Array((77, 130), (84, 131), (3, 4));
    testing(lst, "(20174,34060)(21840,34060)(25545,34060)")
  }
}

object CW5_CommonDenominatorsTest {
  private def ArrayTupleToString(res: Array[(Long, Long)]): String = {
    var s: String = "["
    val l: Int = res.length
    for (i <- 0 until l) {
      val a = res(i)
      s += "(" + a._1 + ", " + a._2
      if (i < l - 1) s += "), " else s += ")"
    }
    s += "]"
    return s
  }

  private def testing(lst: Array[(Long, Long)], expect: String): Unit = {
    println("Testing: " + ArrayTupleToString(lst))
    val actual: String = CW5_CommonDenominators.convertFrac(lst)
    println("Actual: " + actual)
    println("Expect: " + expect)
    println("-")
    assertResult(expect){actual}
  }
}