package part2

object Task3Functions extends App {

  val positive: Int => String = _ match {
    case x if x >= 0 => "positive"
    case x if x < 0  => "negative"
  }

  def positiveDef(x: Int): String = x match {
    case x if x >= 0 => "positive"
    case x if x < 0  => "negative"
  }

  val neg: (String => Boolean) => (String => Boolean) =
    predicate => s => !predicate(s)

  def negDef(predicate: String => Boolean): String => Boolean =
    s => !predicate(s)

  val empty: String => Boolean = _ == ""

  val notEmpty = neg(empty)
  val notEmptyDef = negDef(empty)

  println(positive(10))
  println(positive(-3))

  println(positiveDef(10))
  println(positiveDef(-3))

  println(notEmpty("foo"))
  println(notEmpty(""))
  println(notEmpty("foo") && !notEmpty(""))

  println(notEmptyDef("foo"))
  println(notEmptyDef(""))
  println(notEmptyDef("foo") && !notEmptyDef(""))
}
