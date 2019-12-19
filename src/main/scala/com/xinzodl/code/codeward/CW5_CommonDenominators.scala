package com.xinzodl.code.codeward

// https://www.codewars.com/kata/54d7660d2daf68c619000d95
object CW5_CommonDenominators {

  import scala.annotation.tailrec

  def currentResultIsValid(current: Long, expected: Array[Double]): Boolean = {
    expected.map(_ * current).map( x => (x % 1) == 0 || (x % 1).abs <  0.000000001 || ((x % 1) - 1).abs <  0.000000001).reduce(_ && _)
  }

  @tailrec
  def factors(number: Long, lst: List[Long] = List(), currentFactor: Long = 2): List[Long] = {
    if (number == 1 && lst.isEmpty) {
      List(1)
    } else if (number == 1) {
      lst
    } else {
      (number % currentFactor) match {
        case 0 => factors(number / currentFactor, lst :+ currentFactor, currentFactor)
        case _ => factors(number, lst, currentFactor + 1)
      }
    }
  }

  def convertFrac(lst: Array[(Long, Long)]): String = {
    val expected = lst.map{ case(x,y) => x/y.toDouble}
    val factorsList = lst.flatMap(x => factors(x._2))
    val maxIterations = factorsList.length
    val iterators = (1 to maxIterations).map(factorsList.combinations(_))
    val combinedIterators = iterators.foldLeft(Iterator[Array[Long]]())(_ ++ _)
    val firstArraySolution = combinedIterators.find( x => currentResultIsValid(x.product, expected)).getOrElse(Array(0L))
    val denominator = firstArraySolution.product

    expected.map( x => ((x*denominator).round, denominator)).mkString("")
  }

  // -----------------------------------------------------------------------------------------------------------------------------------------------
  /**
  def convertFrac2(lst: Array[(Long, Long)]): String = {
    val withResults = lst.map( x => (x._1, 1d, (x._1.toDouble / x._2)))
    convertFrac(withResults)
  }

  @tailrec
  private def convertFrac(lst: Array[(Long, Double, Double)]): String = {
    if (lst.exists(x => x._1 / x._2 != x._3)) { // There is at least a pair that does not meet the requirements -> I have not finished yet
      val newLst = lst.map{ case(_, y, z) => ( (z * (y + 1)).round.toLong, y + 1, z)}
      convertFrac(newLst)
    } else { // All pairs meet the requirements -> I have finished -> create return string
      lst.map{ case(x,y,z) => (x, y.toLong)}.mkString
    }
  }
   */

  // -----------------------------------------------------------------------------------------------------------------------------------------------

    /**
  def currentResultIsValid(current: Long, expected: Array[Double]): Boolean = {
    expected.map(_ * current).map( x => (x % 1) == 0 || (x % 1).abs <  0.000000000001 || ((x % 1) - 1).abs <  0.000000000001).reduce(_ && _)
  }

  def convertFrac(lst: Array[(Long, Long)]): String = {
    val min = 1
    val max = lst.map(_._2).product
    val expected = lst.map{ case(x,y) => x/y.toDouble}

    var current = min
    var found = false

    while(!found && current < max) {
      if(currentResultIsValid(current, expected)){
        found = true
      } else {
        current = current + 1
      }
    }

    expected.map( x => ((x*current).round, current)).mkString("")
  }
     */

    //-----------------------------------------------------------------------------------------------------------------------------------------------



  //  def currentResultIsValid(current: Int, expected: Array[Double]): Boolean = {
  //    val possibleDoubleSolution = expected.map(current * _).map(_.round)
  //
  //    val compare = arr.zip(expected)
  //    val qqq = compare.map{ x => (x._1 / current)}
  //    println("################################################################")
  //    println(s"compare = ${compare.mkString("")}")
  //    println(s"qqq = ${qqq.mkString("")}")
  //    (for ( x <- compare) yield {(x._1 / current) == x._2}).reduce(_ && _)
  //  }




  // FROM SOMEONE ELSE

/*
  def convertFracFromSomeoneElse(lst: Array[(Long, Long)]): String = {
    def reduceFraction(f: (Long, Long)): (Long, Long) = {
      f match {
        case (n, d) => {
          val div = gcd(n, d)
          (n/div, d/div)
        }
      }
    }

    def gcd(a: Long, b: Long):Long={
      if (b==0) a.abs else gcd(b, a%b)
    }

    def lcm(a: Long, b: Long)= {
      (a*b).abs/gcd(a,b)
    }

    val reducedFractions = lst.map(reduceFraction)

    val commonDenominator = reducedFractions.map(_._2).reduceLeft(lcm)

    reducedFractions.map { case (n, d) => (n * (commonDenominator/d), commonDenominator) }.mkString
  }
  */

  /*
  object Fracts {

  def convertFrac(lst: Array[(Long, Long)]): String = {
    def reduceFraction(f: (Long, Long)): (Long, Long) =
      f match { case (n, d) => val div = gcd(n, d); (n/div, d/div) }

    def gcd(a: Long, b: Long):Long=if (b==0) a.abs else gcd(b, a%b)
    def lcm(a: Long, b: Long)=(a*b).abs/gcd(a,b)

    val reducedFractions = lst.map(reduceFraction)
    val commonDenominator = reducedFractions.map(_._2).reduceLeft(lcm)
    reducedFractions.map { case (n, d) => (n * (commonDenominator/d), commonDenominator) }.mkString
  }
}
   */





}
