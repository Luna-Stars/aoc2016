package day09

import util.Input

trait Util {

  val data: String = Input.readInput("day9.txt").head

  def decompress(x: String, v: Int): String = {
    var decompressed = ""
    var input = x.replace(" ", "").replace("\n", "")

    while (input.length() > 0) {
      if (input.contains('(')) {
        // step 1: take everything leading up to the marker
        decompressed += input.substring(0, input.indexOf('('))
        input = input.substring(input.indexOf('('))
        // step 2: get marker data and strip
        val numChars = input.substring(1, input.indexOf('x')).toInt
        val repeatCount = input.substring(input.indexOf('x') + 1, input.indexOf(')')).toInt
        input = input.substring(input.indexOf(')') + 1)
        // step 3: pull chars from input and strip
        val repeatChars = if (v == 2) decompress(input.take(numChars), v) else input.take(numChars)
        input = input.substring(numChars)
        // step 3: add repeated chars to decompressed
        decompressed += repeatChars * repeatCount
      } else {
        decompressed += input
        input = ""
      }
    }

    decompressed
  }

}
