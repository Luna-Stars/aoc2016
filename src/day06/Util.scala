package day06

import util.Input

trait Util {
  val data: List[String] = Input.readInput("day6.txt").map(_.stripLineEnd)
}
