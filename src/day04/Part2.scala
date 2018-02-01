package day04

object Part2 extends App with Util {
  data.filter(realRoom).filter(x => decrypt(x) == "northpole object storage").sortBy(_.sec).foreach(x => println("[" + x.sec.toString + "] " + decrypt(x)))
}
