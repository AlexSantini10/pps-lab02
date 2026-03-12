package it.unibo.pps.u02

object Task5Compose extends App {

  def compose(f: Int => Int, g: Int => Int): Int => Int =
    (x: Int) => f(g(x))

  println(compose(_ - 1, _ * 2)(5)) // 9
}