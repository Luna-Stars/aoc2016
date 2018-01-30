package day01

trait Util {

  val NORTH = 0; val EAST = 1; val SOUTH = 2; val WEST = 3

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

}
