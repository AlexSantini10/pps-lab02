package it.unibo.pps.u02

object Task7Power extends App {

  def power(base: Double, exponent: Int): Double = {

    def loop(base: Double, exponent: Int, acc: Double): Double =
      exponent match
        case exponent if exponent > 0 =>
          loop(base, exponent - 1, acc * base)
        case _ => acc

    loop(base, exponent, 1)
  }

  println(power(3, 5))
  println(power(2, 3))
  println(power(5, 2))
}