package com.xinzodl.code.hackerrank

object HR4_betweeenTwoSets {
  // https://www.hackerrank.com/challenges/between-two-sets/problem

  def getTotalX(a: Array[Int], b: Array[Int]): Int = {

    val qq = a.max to b.min
    val result = qq.filter{ x =>
      (a.count(x % _ == 0) == a.length) && (b.count(_ % x == 0) == b.length)
    }

    result.length

  }

  def main(args: Array[String]) {

    val arr = Array(2,6)

    val brr = Array(24, 36)

    println(getTotalX(arr, brr))

  }

}
