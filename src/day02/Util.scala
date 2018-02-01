package day02

import util.Input

trait Util {
  val data: List[String] = Input.readInput("day2.txt").map(_.stripLineEnd)
  def bind(n: Int, low: Int, high: Int): Int = math.min(math.max(n, low), high)
  def getCol(keypad: List[String],  col: Int): String = keypad.map(x => x.charAt(col)).mkString

  // part 2 specific
  val keypad2: List[String] = List("..1..", ".234.", "56789",".ABC.","..D..")
  val EMPTY: Char = '.'
}
