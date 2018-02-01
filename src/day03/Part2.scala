package day03

object Part2 extends App with Util {
  println(data.transpose.flatten.sliding(3, 3).count(validTriangle))
}
