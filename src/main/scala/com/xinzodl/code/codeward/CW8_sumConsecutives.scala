package com.xinzodl.code.codeward

// https://www.codewars.com/kata/55eeddff3f64c954c2000059
object CW8_sumConsecutives {

  def sumConsecutives(xs: List[Int]): List[Int] = xs.foldLeft(0, -1, Array[Int]())( (acc, cur) => {
    val (previousNumber, size, arr) = acc
    if (size == -1) {
      (cur, size + 1, Array(cur))
    } else if (previousNumber == cur) {
      arr(size) = arr(size) + cur
      (cur, size, arr)
    } else {
      (cur, size + 1, arr :+ cur)
    }
  })._3.toList

  /* ---- cool solution from someone else
  def sumConsecutives(xs: List[Int]): List[Int] =
    if (xs.isEmpty) Nil else xs.span(_ == xs.head) match { case (a, b) => a.sum :: sumConsecutives(b) }
   */

}
