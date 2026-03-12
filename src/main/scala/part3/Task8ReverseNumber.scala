package it.unibo.pps.u02

object Task8ReverseNumber extends App {

  def reverseNumber(n: Int): Int = {

    def loop(n: Int, acc: Int): Int =
      n match
        case n if n > 0 =>
          loop(n / 10, acc * 10 + n % 10)
        case _ => acc

    loop(n, 0)
  }

  println(reverseNumber(12345))
}