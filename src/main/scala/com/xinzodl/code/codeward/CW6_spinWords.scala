package com.xinzodl.code.codeward

// https://www.codewars.com/kata/5264d2b162488dc400000001
object CW6_spinWords {

  def spinWords(sentence: String): String = {
    sentence.trim.split(" ").map( x => {
      if (x.length >= 5) x.reverse else x
    }).mkString(" ")
  }

}
