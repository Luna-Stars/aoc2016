package day08

object Part1 extends App with Util {
  data.foreach(x => grid = parseInstr(x, grid))
  println(grid.map(x => x.count(_.equals(ON))).sum)
}
