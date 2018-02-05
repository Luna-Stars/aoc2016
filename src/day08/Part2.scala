package day08

object Part2 extends App with Util {
  data.foreach(x => grid = parseInstr(x, grid))
  grid.foreach(x => println(x.mkString))
}
