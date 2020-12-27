package com.xinzodl.code.hackerrank

import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

/*
  s: integer, starting point of Sam's house location.
  t: integer, ending location of Sam's house location.
  a: integer, location of the Apple tree. to the left of the house
  b: integer, location of the Orange tree. to the right of the house
  apples: integer array, distances at which each apple falls from the tree.
  oranges: integer array, distances at which each orange falls from the tree.
 */
object HR2_appleAndOrange {
  // https://hackerrank.com/challenges/apple-and-orange/problem


  def countApplesAndOranges(s: Int, t: Int, a: Int, b: Int, apples: Array[Int], oranges: Array[Int]) {
    // "normalize apples taken s as 0"
    println(apples.map(_ + a).count(x => x >= s && x <= t))
    println(oranges.map(_ + b).count(x => x >= s && x <= t))

  }

  def main(args: Array[String]) {
    val s = 7
    val t = 11
    val a = 5
    val b = 15
    val apples = Array(-1,2,1)
    val oranges = Array(5, -6)
    countApplesAndOranges(s, t, a, b, apples, oranges)
  }
}