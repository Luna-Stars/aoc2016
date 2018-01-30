package day01

import util.Input

object Part2 extends App {

  val NORTH = 0; val EAST = 1; val SOUTH = 2; val WEST = 3
  val data = Input.readInput("day1.txt").head.stripLineEnd.split(", ").map(x => (x.charAt(0), x.substring(1).toInt))

  def move(pos: (Int, Int), direction: Int, amt: Int): (Int, Int) = {
    if (direction == NORTH) (pos._1, pos._2 + amt)
    else if (direction == SOUTH) (pos._1, pos._2 - amt)
    else if (direction == EAST) (pos._1 + amt, pos._2)
    else if (direction == WEST) (pos._1 - amt, pos._2)
    else (Int.MinValue, Int.MinValue)
  }

  def updateDir(dir: Int, char: Char): Int = {
    if (char == 'R') {
      if (dir == WEST) NORTH else dir + 1
    } else {
      if (dir == NORTH) WEST else dir - 1
    }
  }

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
