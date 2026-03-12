package part2

object Task4Currying extends App {

  val p1: Int => Int => Int => Boolean =
    x => y => z => (x <= y && y == z)

  println(p1(3)(4)(5))
  println(p1(3)(4)(4))

  val p2: (Int, Int, Int) => Boolean =
    (x, y, z) => (x <= y && y == z)

  println(p2(3, 4, 5))
  println(p2(3, 4, 4))

  def p3(x: Int)(y: Int)(z: Int): Boolean =
    (x <= y && y == z)

  println(p3(3)(4)(5))
  println(p3(3)(4)(4))

  def p4(x: Int, y: Int, z: Int): Boolean =
    (x <= y && y == z)

  println(p4(3, 4, 5))
  println(p4(3, 4, 4))
}