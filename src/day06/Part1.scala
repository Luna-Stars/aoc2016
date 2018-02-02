package day06

object Part1 extends App with Util {
  println(data.transpose.map(x => x.groupBy(identity).maxBy(_._2.size)._1).mkString)
}
