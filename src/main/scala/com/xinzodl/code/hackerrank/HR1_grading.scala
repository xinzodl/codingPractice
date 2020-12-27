package com.xinzodl.code.hackerrank

import java.io._
import scala.io._

object HR1_grading {
  // https://www.hackerrank.com/challenges/grading/problem

  private def Round(value: Int): Int = {
    // If the difference between the grade and the next multiple of 5 is less than 3, round grade up to the next multiple of 5.
    val valuePlus2 = value + 2
      if( valuePlus2  % 5  < 3) {
        valuePlus2 - (valuePlus2 % 5)
      } else {
        value
      }
  }

  def gradingStudents(grades: Array[Int]): Array[Int] = {
    grades.map( x => if(x >37) Round(x) else x)
  }

  def main(args: Array[String]) {
    val grades: Array[Int] = Array(73,67,38,33)

    val result = gradingStudents(grades)

    println(result.mkString("\n"))
  }


}
