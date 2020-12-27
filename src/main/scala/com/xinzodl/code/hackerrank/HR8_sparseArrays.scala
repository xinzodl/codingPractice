package com.xinzodl.code.hackerrank

object HR8_sparseArrays {
  // https://www.hackerrank.com/challenges/sparse-arrays/problem

  def matchingStrings(strings: Array[String], queries: Array[String]): Array[Int] = {
    queries.map(x => strings.count(y => x.equals(y)))
  }

  def main(args: Array[String]) {

    val strings = Array("aba", "baba", "aba", "xzxb")

    val queries = Array("aba","xzxb","ab")

    val res = matchingStrings(strings, queries)

    println(res.mkString(", "))
  }

}
