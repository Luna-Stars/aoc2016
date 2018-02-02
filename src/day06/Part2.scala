package day06

object Part2 extends App with Util {
  println(data.transpose.map(x => x.groupBy(identity).minBy(_._2.size)._1).mkString)
}
