package util

import scala.io.Source

object Input {
  def readInput(file: String): List[String] = {
    val bufferedSource = Source.fromFile("input/"+file)
    val lines = bufferedSource.getLines.toList
    bufferedSource.close
    lines
  }
}
