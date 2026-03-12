package it.unibo.pps.u02

object MyTests extends App{
  println("\n=== Avvio ===")
  println("Hello, World!")

  println("\n=== Funzioni base ===")
  val f : (Int, Int) => Int = (x, y) => x * y
  println(f(12, 11))

  def g(x: Int, y: Int) : Int = x * y
  println(g(6, 5))

  println("\n=== Test currying ===")
  // Test currying
  // standard function with no currying
  def mult(x: Double, y: Double): Double = x * y

  // function with currying
  // curriedMult has actually type: Double => (Double => Double)
  def curriedMult(x: Double)(y: Double): Double = x * y

  println(mult(2, 3))

  println(curriedMult(2)(3))

  val multBy3 = curriedMult(3)

  println(multBy3(2))

  println("\n=== Pattern matching: Int => String ===")
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

  println("\n=== Predicati su String e negazione ===")

  val strPositive: String => Boolean = x => x match {
    case x if x == "positive" => true
    case x if x == "negative" => false
  }


  // Neg
  val neg: (String => Boolean) => (String => Boolean) = predicate => s => !predicate(s)

  //def neg2(predicate: (String => Boolean)): (String => Boolean) =

  val negative = neg(strPositive)

  println(negative(positive(32)))



  // Curried functions
  println("\n=== Curried functions ===")
  val p1: Int => Int => Int => Boolean = x => y => z => (x <= y && y == z)
  println(p1(3)(4)(5))
  println(p1(3)(4)(4))

  val p2: (Int, Int, Int) => Boolean = (x, y, z) => (x <= y && y == z)
  println(p2(3, 4, 5))
  println(p2(3, 4, 4))

  def p3(x: Int)(y: Int)(z: Int): Boolean = (x <= y && y == z)
  println(p3(3)(4)(5))
  println(p3(3)(4)(4))

  def p4(x: Int, y: Int, z: Int): Boolean = (x <= y && y == z)
  println(p4(3, 4, 5))
  println(p4(3, 4, 4))


  // Function composition
  //compose(f: Int => Int, g: Int => Int): Int => Int
  println("\n=== Function composition ===")
  def compose(f: Int => Int, g: Int => Int): Int => Int = (x: Int) => f(g(x))

  println(compose(_ - 1, _ * 2)(5)) // 9

  // Recursion
  println("\n=== Function recursion - powers ===")
//  def power(base: Double, exponent: Int): Double = exponent match
//    case exponent if (exponent > 0) => base * power(base, exponent - 1)
//    case _ => 1

  def power(base: Double, exponent: Int): Double = {
    def loop(base: Double, exponent: Int, acc: Double): Double = exponent match
      case exponent if exponent > 0 => loop(base, exponent - 1, acc * base)
      case _ => acc

    loop(base, exponent, 1)
  }

  println(power(3, 5))
  println(power(2, 3))
  println(power(5, 2))


  // Reverse digits
  println("\n=== Function recursion - reverse digits ===")
  def reverseNumber(n: Int): Int = {
    def loop(n: Int, acc: Int) : Int = n match
      case n if n>0 => loop(n/10, acc * 10 + n % 10)
      case _ => acc

    loop(n, 0)
  }

  println(reverseNumber(12345)) // 54321

  // Expr
  println("\n=== Class Expr ===")
  enum Expr:
    case Literal(value: Int)
    case Add(left: Expr, right: Expr)
    case Multiply(left: Expr, right: Expr)


  // High order functions, other tests
  println("\n=== High order functions, altri test ===")

  def max(x: Int, y: Int): Int = if (x>=y) x else y
  val max: (Int, Int) => Int = (x, y) => if (x>=y) x else y

  val apply: (Int, Int, (Int, Int) => Int) => Int = (x, y, func) => func(x, y)

  println(apply(3, 7, (x: Int, y: Int) => if (x%2==0) x else y))
  println(apply(5, 7, max))
}
