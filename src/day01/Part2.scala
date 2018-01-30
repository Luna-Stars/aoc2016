package day01

import util.Input

object Part2 extends App with Util {

  val data = Input.readInput("day1.txt").head.stripLineEnd.split(", ").map(x => (x.charAt(0), x.substring(1).toInt))

  var coords = (0,0)
  var dir = NORTH
  var visited = List[(Int, Int)]()
  var found = false

  for (x <- data if !found) {
    dir = updateDir(dir, x._1)
    for (i <- 1 to x._2 if !found) {
      coords = move(coords, dir, 1)
      if (visited.contains(coords)) {
        found = true
        println(math.abs(coords._1) + math.abs(coords._2))
      } else visited = coords :: visited
    }
  }

}
