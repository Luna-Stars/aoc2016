package day04

object Part1 extends App with Util {
  println(data.filter(realRoom).map(_.sec).sum)
}
