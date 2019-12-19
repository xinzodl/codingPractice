package com.xinzodl.code.codeward

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

// https://www.codewars.com/kata/556deca17c58da83c00002db
class CW2_TribonacciTest extends AnyFlatSpec with Matchers {
  Seq[((List[Double], Int), List[Double])](
    ((List(1, 1, 1), 10), List(1, 1, 1, 3, 5, 9, 17, 31, 57, 105)),
    ((List(0, 0, 1), 10), List(0, 0, 1, 1, 2, 4, 7, 13, 24, 44)),
    ((List(0, 1, 1), 10), List(0, 1, 1, 2, 4, 7, 13, 24, 44, 81)),
    ((List(1, 0, 0), 10), List(1, 0, 0, 1, 1, 2, 4, 7, 13, 24)),
    ((List(0, 0, 0), 10), List(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)),
    ((List(1, 2, 3), 10), List(1, 2, 3, 6, 11, 20, 37, 68, 125, 230)),
    ((List(3, 2, 1), 10), List(3, 2, 1, 6, 9, 16, 31, 56, 103, 190)),
    ((List(1, 1, 1), 1), List(1)),
    ((List(300, 200, 100), 0), List()),
    ((List(0.5, 0.5, 0.5), 30), List(0.5, 0.5, 0.5, 1.5, 2.5, 4.5, 8.5, 15.5, 28.5, 52.5, 96.5, 177.5, 326.5, 600.5, 1104.5, 2031.5, 3736.5, 6872.5, 12640.5, 23249.5, 42762.5, 78652.5, 144664.5, 266079.5, 489396.5, 900140.5, 1655616.5, 3045153.5, 5600910.5, 10301680.5))
  ) foreach { case (params, result) =>
    s"tribonacci for $params" should s"be $result" in {
      CW2_Tribonacci.tribonacci(params._1, params._2) shouldBe result
    }
  }
}