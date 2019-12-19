package com.xinzodl.code.codeward

// https://www.codewars.com/kata/558fc85d8fd1938afb000014
object CW3_sumTwoSmallest {
  def sumTwoSmallest(numbers: List[Int]): Int = {
    if (numbers.size <= 2) {
      numbers.sum
    } else {
      val min = numbers.min
      val min2 = numbers.filter(_ != numbers.min).min
      min + min2
    }
  }
}
