package com.xinzodl.code.hackerrank

object HR7_divisibleSumPairs {
  // https://www.hackerrank.com/challenges/divisible-sum-pairs/problem

  def getAllPairs(myArr: Array[Int]): Array[(Int, Int)] = {
    myArr.indices.combinations(2).toArray.map(v => (myArr(v(0)), myArr(v(1))))
  }

  def divisibleSumPairs(n: Int, k: Int, ar: Array[Int]): Int = {
    getAllPairs(ar).count(x => (x._1 + x._2) % k == 0)
  }

  def main(args: Array[String]) {
    val n = 0 // length of array

    val k = 3 // value

    val ar = Array(1, 3, 2, 6, 1, 2)

    val result = divisibleSumPairs(n, k, ar)

    println(result)
  }

}
