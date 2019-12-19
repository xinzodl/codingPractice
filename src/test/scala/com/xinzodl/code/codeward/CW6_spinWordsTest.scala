package com.xinzodl.code.codeward

import org.scalatest.funspec.AnyFunSpec

// https://www.codewars.com/kata/5264d2b162488dc400000001
class CW6_spinWordsTest extends AnyFunSpec {
  describe("CW6_spinWords.spinWords") {
    it("should work with example tests") {
      assertResult ("emocleW") {CW6_spinWords.spinWords("Welcome")}
      assertResult ("Hey wollef sroirraw") {CW6_spinWords.spinWords("Hey fellow warriors")}
      assertResult ("This is a test") {CW6_spinWords.spinWords("This is a test")}
      assertResult ("This is rehtona test") {CW6_spinWords.spinWords("This is another test")}
      assertResult ("You are tsomla to the last test") {CW6_spinWords.spinWords("You are almost to the last test")}
      assertResult ("Just gniddik ereht is llits one more") {CW6_spinWords.spinWords("Just kidding there is still one more")}
      assertResult ("ylsuoireS this is the last one") {CW6_spinWords.spinWords("Seriously this is the last one")}
    }
  }
}
