package day07

import java.util.regex.{Matcher, Pattern}

import util.Input

trait Util {
  val data: List[String] = Input.readInput("day7.txt").map(_.stripLineEnd)

  def getHypernets(x: String): List[String] = {
    var hypernets = List[String]()
    val m = Pattern.compile("\\[[^\\]]+\\]").matcher(x)
    while (m.find()) {
      hypernets = hypernets ++ List(m.group(0).replace("[","").replace("]",""))
    }
    hypernets
  }

  def getNotH(x: String): List[String] = {
    var notH = List[String]()
    val m = Pattern.compile("(^[^\\[]+)|(\\][^\\[]+\\[)|(\\][^\\[]+$)").matcher(x)
    while (m.find) notH ++= List(m.group(0).replace("[", "").replace("]", ""))
    notH
  }

  def isABBA(x: String): Boolean = x.length() == 4 && x.substring(0, 2).equals(x.substring(2, 4).reverse) && x.charAt(0) != x.charAt(1)
  def hasABBA(x: String): Boolean = x.sliding(4).exists(isABBA)
  def isTLS(x: String): Boolean = !getHypernets(x).exists(hasABBA) && getNotH(x).exists(hasABBA)

  def isABA(x: String): Boolean = x.length() == 3 && x.charAt(0) == x.charAt(2) && x.charAt(0) != x.charAt(1)
  def getBAB(x: String): String = List(x.charAt(1), x.charAt(0), x.charAt(1)).mkString
  def findABAs(x: String): List[String] = getNotH(x).flatMap(x => x.sliding(3).filter(isABA))
  def babMatch(x: String, aba: String): Boolean = getHypernets(x).flatMap(_.sliding(3)).exists(_.equals(getBAB(aba)))

  def isSSL(x: String): Boolean = findABAs(x).exists(babMatch(x, _))

}
