package day08

import util.Input

trait Util {
  // constants
  val ON = '@'; val OFF = ' '

  // data
  val data: List[String] = Input.readInput("day8.txt")
  var grid: List[List[Char]] = List.tabulate(6, 50) ((x, y) => OFF)

  // grid manipulation
  def rect(x: Int, y: Int, grid: List[List[Char]]): List[List[Char]] = {
    grid.take(y).map(b => (for (i <- 1 to x) yield ON).toList ++ b.takeRight(b.length - x)) ++ grid.takeRight(grid.length - y)
  }

  def rotateRow(row: Int, amt: Int, grid: List[List[Char]]): List[List[Char]] = {
    grid.take(row) ++ List(grid(row).takeRight(amt) ++ grid(row).take(grid(row).length - amt)) ++ grid.takeRight(grid.length - row - 1)
  }

  def rotateCol(col: Int, amt: Int, grid: List[List[Char]]): List[List[Char]] = {
    rotateRow(col, amt, grid.transpose).transpose
  }

  // parsing
  def parseInstr(instr: String, grid: List[List[Char]]): List[List[Char]] = {
    val keyword = instr.substring(0, instr.indexOf(' ')); val args = instr.substring(instr.indexOf(' ') + 1)
    if (keyword.equals("rect")) {  // handle a rectangle
      val x = args.substring(0, args.indexOf('x')).toInt
      val y = args.substring(args.indexOf('x') + 1).toInt
      rect(x, y, grid)
    } else {  // otherwise, rotate
      val rotKeyword = args.split(' ').head; val x = args.split(' ')(1).substring(2).toInt; val amt = args.split(' ').last.toInt
      if (rotKeyword.equals("row")) rotateRow(x, amt, grid) else rotateCol(x, amt, grid)
    }
  }
}
