package day03

import util.Input

trait Util {
  def clean(x: String): Int = x.replace(" ", "").toInt

  val data: List[List[Int]] = Input.readInput("day3.txt").map(x => {
    List(clean(x.substring(0,5)), clean(x.substring(6, 10)), clean(x.substring(11)))
  })

  def validTriangle(x: List[Int]): Boolean = {
    (x.head + x(1) > x(2)) && (x(1) + x(2) > x.head) && (x(2) + x.head > x(1))
  }
}
