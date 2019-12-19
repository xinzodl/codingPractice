package com.xinzodl.code.codeward

import scala.annotation.tailrec

// https://www.codewars.com/kata/5592e3bd57b64d00f3000047
object CW4_findNb {

  def findNb(m: Long): Int = {
    findNbTailRec(m, 0, 0)
  }

  @tailrec
  private def findNbTailRec(m: Long, index: Int, acc: Long): Int = {
    if (acc > m) {
      -1
    } else if (acc == m) {
      index
    } else {
      val newIndex = index + 1
      findNbTailRec(m, newIndex, acc + Math.pow(newIndex, 3).toLong)
    }
  }

}