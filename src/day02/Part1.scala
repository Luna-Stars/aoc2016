package day02

object Part1 extends App with Util {
  def move(coords: (Int, Int), char: Char, keyWidth: Int): (Int, Int) = {
    val motion = if (char != 'U' && char != 'L') 1 else -1
    if (char == 'U' || char == 'D') (coords._1, bind(coords._2 + motion, 0, keyWidth - 1))
    else (bind(coords._1 + motion, 0, keyWidth - 1), coords._2)
  }
  def getKey(coords: (Int, Int)): Int = (coords._2 * 3) + coords._1 + 1
  var coords = (1, 1); var key = ""
  data.foreach(x => {
    x.foreach(y => {
      coords = move(coords, y, 3)
    })
    key += getKey(coords).toString
  })
  println(key)
}
