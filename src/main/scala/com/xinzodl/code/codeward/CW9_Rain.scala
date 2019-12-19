package com.xinzodl.code.codeward

// https://www.codewars.com/kata/56a32dd6e4f4748cc3000006
object CW9_Rain {

  private def getValues(town: String, data: String): Array[Double] = {
    val valuesOfTown = data.split("\n").filter(_.contains(town + ":"))
    if (valuesOfTown.isEmpty) {
      Array()
    } else {
      valuesOfTown(0).split(":").tail(0).split(",").map(_.drop(4).toDouble)
    }
  }

  def mean(town: String, strng: String): Double = {
    val values = getValues(town, strng)
    if (values.isEmpty) {
      -1d
    } else {
      values.sum / values.length
    }
  }

  def variance(town: String, strng: String): Double = {
    import scala.math.pow

    val values = getValues(town, strng)
    if (values.isEmpty) {
      -1d
    } else {
      val length = values.length
      val myMean = mean(town, strng)
      values.map( x => pow((x - myMean), 2) / length).sum
    }
  }



}
