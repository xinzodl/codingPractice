package com.xinzodl.code.hackerrank

import scala.collection.mutable
import scala.io.Source

object HR8_arrayManipilation {
  // https://www.hackerrank.com/challenges/crush/problem

  def arrayManipulation(n: Int, queries: Array[Array[Int]]): Long = {
    val values = Array.ofDim[Long](n+2)

    queries.foreach{ x =>
      values(x(0)) += x(2)
      values(x(1) + 1) -= x(2)
    }

    var max = 0L
    var acc = 0L
    values.foreach{ v =>
      acc += v
      if (max < acc) max = acc
    }

    max

  }

//  def arrayManipulation(n: Int, queries: Array[Array[Int]]): Long = {
//    var mp0: mutable.Map[Int, Long] = scala.collection.mutable.Map[Int, Long]()
//
//    queries.foreach { z =>
//      for (i <- (z(0) - 1) until z(1)){
//        mp0 += mp0.get(i).map(x => i -> (x + z(2))).getOrElse(i -> z(2))
//      }
//    }
//
//    mp0.values.max
//
//  }

  def main(args: Array[String]) {
    val n = 10000000 // number of elements in the array

//    val queries = Array(Array(1,2,100),Array(2,5,100),Array(3,4,100)) // each one is a 3 element

    val queries = Source.fromFile("C:\\Users\\XinZodl-XPS13\\Desktop\\testCases.txt").getLines.toArray.map(_.split(" ").map(_.toInt))

    val result = arrayManipulation(n, queries)

    println(result)
  }

}
