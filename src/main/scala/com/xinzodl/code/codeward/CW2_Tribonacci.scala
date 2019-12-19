package com.xinzodl.code.codeward

// https://www.codewars.com/kata/556deca17c58da83c00002db
object CW2_Tribonacci {
  def tribonacci[T : Numeric](signature: List[T], n: Int): List[T] = {
    if (n <= 3) signature.take(n) else {
      val newList = (4 to n).foldLeft(signature){ case (acc, _) =>
        val newDigit = acc.takeRight(3).sum
        acc :+ newDigit
      }
      newList
    }}
}
