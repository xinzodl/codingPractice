package com.xinzodl.code.hackerrank

object HR5_breakingTheRecords {
  // https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem

  def breakingRecords(scores: Array[Int]): Array[Int] = {

    val board = scores.foldLeft( (0, scores(0), 0, scores(0)) ){ case ((minCount, min, maxCount, max), curr) =>
      if (curr < min) { // new min
        (minCount + 1, curr, maxCount, max)
      } else if (curr > max) { // new max
        (minCount, min, maxCount + 1, curr)
      } else {
        (minCount, min, maxCount, max)
      }
    }

    Array(board._3, board._1)

  }

  def main(args: Array[String]) {

    val scores = Array(10, 5, 20, 20, 4, 5, 2, 25, 1)

    val result = breakingRecords(scores)

    println(result.mkString(" "))

  }

}
