package day02

object Part2 extends App with Util {

  def move(coords: (Int, Int), char: Char, keypad: List[String]): (Int, Int) = {
    val motion = if (char == 'U' || char == 'L') -1 else 1
    val new_coords = if (char == 'U' || char == 'D') {
      (coords._1, bind(coords._2 + motion, 0, keypad.length - 1))
    }  else (bind(coords._1 + motion, 0, keypad.length - 1), coords._2)
    if (getKey(new_coords, keypad) == EMPTY) coords else new_coords
  }

  def getKey(coords: (Int, Int), keypad: List[String]): Char = keypad(coords._2).charAt(coords._1)

  var coords = (0, 2)
  data.foreach(x => {
    x.foreach(y => {
      coords = move(coords, y, keypad2)
    })
    print(getKey(coords, keypad2))
  })
  println()

}
