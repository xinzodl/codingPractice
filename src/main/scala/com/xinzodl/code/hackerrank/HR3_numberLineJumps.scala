package com.xinzodl.code.hackerrank

object HR3_numberLineJumps {
// https://www.hackerrank.com/challenges/kangaroo/problem?


  // Complete the kangaroo function below.
  def kangaroo(x1: Int, v1: Int, x2: Int, v2: Int): String = {

    // we need v1 > v2
    val first = v1 > v2
    // and we need the difference between x2 and x1 to be multiple of the difference between v1 qnd v2
    def second = (x2-x1) % (v1-v2) == 0

    if ( first && second ) "YES" else "NO"

  }

  def main(args: Array[String]) {

    val x1: Int = 0

    val v1: Int = 3

    val x2: Int = 4

    val v2: Int = 2

    val result = kangaroo(x1, v1, x2, v2) // se llega en 12

    println(result)
  }

}
