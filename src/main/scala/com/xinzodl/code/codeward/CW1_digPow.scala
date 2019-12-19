package com.xinzodl.code.codeward

// https://www.codewars.com/kata/5552101f47fc5178b1000050
object CW1_digPow {
  def digPow(n: Int, p: Int): Int = {
    val length: Int = (Math.log10(n) + 1).toInt
    val digits = n.toString.toCharArray.map( x => x.asDigit)
    val base = (1 to length).map( x => (x, p + x - 1) )
    val powered = base.map { case (pos, pow) => Math.pow(digits(pos - 1), pow) }.sum
    val k = powered / n

    if (k % 1 == 0) k.toInt else -1
  }
}
