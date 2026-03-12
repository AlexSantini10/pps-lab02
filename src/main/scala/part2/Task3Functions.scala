package part2

object Task3Functions extends App {

  val positive: Int => String = _ match {
    case x if x >= 0 => "positive"
    case x if x < 0 => "negative"
  }

  println(positive(10))
  println(positive(-3))

  def positiveDef(x: Int): String = x match {
    case x if x >= 0 => "positive"
    case x if x < 0 => "negative"
  }

  println(positiveDef(10))
  println(positiveDef(-3))

  val strPositive: String => Boolean = x => x match {
    case x if x == "positive" => true
    case x if x == "negative" => false
  }

  val neg: (String => Boolean) => (String => Boolean) =
    predicate => s => !predicate(s)

  val negative = neg(strPositive)

  println(negative(positive(32)))
}