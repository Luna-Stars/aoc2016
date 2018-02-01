package day04

import util.Input

trait Util {

  class Room(val name: String, val sec: Int, val checksum: String) {
    override def toString: String = "[" + name + "," + sec.toString + "," + checksum + "]"
  }

  val data: List[Room] = Input.readInput("day4.txt").map(x => {
    new Room(x.substring(0, x.lastIndexOf('-')),
             x.substring(x.lastIndexOf('-') + 1, x.indexOf('[')).toInt,
             x.substring(x.indexOf('[') + 1, x.indexOf(']')))
  })

  def checksum(x: String): String = {
    val freqs = x.replace("-", "").groupBy(_.toChar).mapValues(_.length).toList
    val sortedChars = freqs.groupBy(_._2).toList.sortWith(_._1 > _._1).flatMap(x => x._2.map(y => y._1).sorted)
    sortedChars.take(5).mkString
  }

  def realRoom(x: Room): Boolean = checksum(x.name) == x.checksum

  private def shift(c: Char, shift: Int): Char = {
    val chars = "abcdefghijklmnopqrstuvwxyz"
    chars.charAt((chars.indexOf(c) + shift) % 26)
  }

  def decrypt(r: Room): String = {
    r.name.map(x => if (x == '-') ' ' else shift(x, r.sec))
  }

}
