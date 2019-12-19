package com.xinzodl.code.codeward

// https://www.codewars.com/kata/52f787eb172a8b4ae1000a34
object CW7_zeros {

  import scala.math.pow
  import scala.math.log10

  def zeros(n: Int): Int = {
    val log5Floor = (x: Double) => (log10(x)/log10(5.0)).toInt
    val range = (1 to log5Floor(n)).map(n / pow(5, _).toInt).sum
    range
  }

  /* ------------- v6

  import scala.annotation.tailrec

  @tailrec
  final def factorsTwoAndFive(number: Int, lst: List[Int] = List(), currentFactor: Int = 2): (Int, Int) = {
    if (number == 1 || currentFactor > 5) {
      (lst.count(_ == 2), lst.count(_ == 5))
    } else {
      number % currentFactor match {
        case 0 => factorsTwoAndFive(number / currentFactor, lst :+ currentFactor, currentFactor)
        case _ => factorsTwoAndFive(number, lst, currentFactor + 3)
      }
    }
  }

  import scala.math.min

  def zeros(n: Int): Int = {
    val (two, five)  = (1 to n).foldLeft((0, 0))( (acc, cur) => {
      if (cur % 2 == 0 || cur % 5 == 0) {
        val (curr2, curr5) = factorsTwoAndFive(cur)
        (acc._1 + curr2, acc._2 + curr5)
      } else {
        acc
      }
    })
    min(two, five)
  }

   */
  /* ------------ v5
    import scala.annotation.tailrec

  @tailrec
  final def factorsTwoAndFive(number: Int, lst: List[Int] = List(), currentFactor: Int = 2): (Int, Int) = {
    if (number == 1 || currentFactor > 5) {
      (lst.count(_ == 2), lst.count(_ == 5))
    } else {
      number % currentFactor match {
        case 0 => factorsTwoAndFive(number / currentFactor, lst :+ currentFactor, currentFactor)
        case _ => factorsTwoAndFive(number, lst, currentFactor + 3)
      }
    }
  }

  import scala.math.min

  def zeros(n: Int): Int = {
    val allWith2Or5factors = (1 to n).filter( x => x % 2 == 0 || x % 5 == 0 )
    val (two, five)  = allWith2Or5factors.foldLeft((0, 0))( (acc, cur) => {
      val (curr2, curr5) = factorsTwoAndFive(cur)
      (acc._1 + curr2, acc._2 + curr5)
    })
    min(two, five).toInt
  }

   */

  /* ---------- v4
    import scala.annotation.tailrec

  @tailrec
  final def factorsTwoAndFive(number: Long, lst: List[Long] = List(), currentFactor: Long = 2): (Long, Long) = {
    if (number == 1 || currentFactor > 5) {
      (lst.count(_ == 2L), lst.count(_ == 5L))
    } else {
      number % currentFactor match {
        case 0 => factorsTwoAndFive(number / currentFactor, lst :+ currentFactor, currentFactor)
        case _ => factorsTwoAndFive(number, lst, currentFactor + 3)
      }
    }
  }

  import scala.math.min

  def zeros(n: Int): Int = {
    val all = (1 to n).map(factorsTwoAndFive(_))
    val (two, five) = all.foldLeft((0L, 0L))( (acc, curr) => {
      (acc._1 + curr._1, acc._2 + curr._2)
    })
    min(two, five).toInt
  }

   */
  /* --------- v3
    import scala.annotation.tailrec

  @tailrec
  def factors(number: Long, lst: List[Long] = List(), currentFactor: Long = 2): List[Long] = {
    if (number == 1 && lst.isEmpty) {
      List(1)
    } else if (number == 1 || currentFactor > 5) {
      lst
    } else {
      (number % currentFactor) match {
        case 0 if currentFactor == 2L || currentFactor == 5L => factors(number / currentFactor, lst :+ currentFactor, currentFactor)
        case 0 => factors(number / currentFactor, lst :+ currentFactor, currentFactor)
        case _ => factors(number, lst, currentFactor + 1)
      }
    }
  }

  import scala.math.min

  def zeros(n: Int): Int = {
    val all = (1 to n).map(factors(_))
    val two = all.flatMap(_.filter(_ == 2L)).length
    val five = all.flatMap(_.filter(_ == 5L)).length
    min(two, five)
  }
   */

  /* ------------ v2
    val all = (1 to n).map(factors(_))
    val two = all.flatMap(_.filter(_ == 2L)).length
    val five = all.flatMap(_.filter(_ == 5L)).length
    min(two, five)
   */


/*  ---------- v1
    val twoAndFive = (1 to n).flatMap(factors(_)).filter( x => x == 2 || x == 5)

    import scala.math.min
    val amountOfPairs = min(twoAndFive.count(_ == 2), twoAndFive.count(_ == 5))
    amountOfPairs
 */

}
