package day01

import util.Input

object Part1 extends App with Util {

  val data = Input.readInput("day1.txt").head.stripLineEnd.split(", ").map(x => (x.charAt(0), x.substring(1).toInt))

  var coords = (0,0)
  var dir = NORTH

  for (x <- data) {
    dir = updateDir(dir, x._1)
    coords = move(coords, dir, x._2)
  }

  println(math.abs(coords._1) + math.abs(coords._2))
}
