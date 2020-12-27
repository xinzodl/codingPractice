package com.xinzodl.code.hackerrank

object HR6_subArrayDivision {
  // https://www.hackerrank.com/challenges/the-birthday-bar/problem

  def birthday(s: Array[Int], d: Int, m: Int): Int = {

    s.sliding(m).count(_.sum == d)

  }

  def main(args: Array[String]) {


    val s = Array(1)

    val d = 0 // sum

    val m = 0 // length

    val result = birthday(s, d, m)

    println(result)

  }

}
