object Lab2 extends App:

  // Task 1 - svolto da solo
  println("Task 1")
  println("Hello, Scala")

  // Task 2 - svolto da solo
  // REPL experiments documented separately in Task2.md
  println("\nTask 2")
  println("REPL experiments documented in Task2.md")

  // Task 3 - svolto da solo
  println("\nTask 3")

  val positive: Int => String = _ match
    case x if x >= 0 => "positive"
    case _           => "negative"

  def positiveDef(x: Int): String = x match
    case x if x >= 0 => "positive"
    case _           => "negative"

  val neg: (String => Boolean) => (String => Boolean) =
    p => s => !p(s)

  def negDef(p: String => Boolean): String => Boolean =
    s => !p(s)

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

  // Task 4 - svolto da solo
  println("\nTask 4")

  val p1: Int => Int => Int => Boolean =
    x => y => z => x <= y && y == z

  val p2: (Int, Int, Int) => Boolean =
    (x, y, z) => x <= y && y == z

  def p3(x: Int)(y: Int)(z: Int): Boolean =
    x <= y && y == z

  def p4(x: Int, y: Int, z: Int): Boolean =
    x <= y && y == z

  println(p1(3)(4)(5))
  println(p1(3)(4)(4))
  println(p2(3, 4, 5))
  println(p2(3, 4, 4))
  println(p3(3)(4)(5))
  println(p3(3)(4)(4))
  println(p4(3, 4, 5))
  println(p4(3, 4, 4))

  // Task 5 - svolto da solo
  println("\nTask 5")

  def compose(f: Int => Int, g: Int => Int): Int => Int =
    x => f(g(x))

  println(compose(_ - 1, _ * 2)(5))

  // Task 7 - svolto da solo
  println("\nTask 7")

  def power(b: Double, e: Int): Double =

    def powerRec(e: Int, a: Double): Double = e match
      case x if x > 0 => powerRec(x - 1, a * b)
      case _          => a

    powerRec(e, 1)

  println(power(3, 5))
  println(power(2, 3))
  println(power(5, 2))

  // Task 8 - svolto da solo
  println("\nTask 8")

  def reverseNumber(n: Int): Int =

    def reverseRec(n: Int, a: Int): Int = n match
      case x if x > 0 => reverseRec(x / 10, a * 10 + x % 10)
      case _          => a

    reverseRec(n, 0)

  println(reverseNumber(12345))

  // Task 8 - Expr - svolto da solo
  println("\nTask 8 - Expr")

  enum Expr:
    case Literal(value: Int)
    case Add(left: Expr, right: Expr)
    case Multiply(left: Expr, right: Expr)

  object ExprModule:

    def evaluate(expr: Expr): Int = expr match
      case Expr.Literal(value)        => value
      case Expr.Add(left, right)      => evaluate(left) + evaluate(right)
      case Expr.Multiply(left, right) => evaluate(left) * evaluate(right)

    def show(expr: Expr): String = expr match
      case Expr.Literal(value)        => value.toString
      case Expr.Add(left, right)      => "(" + show(left) + " + " + show(right) + ")"
      case Expr.Multiply(left, right) => "(" + show(left) + " * " + show(right) + ")"

  val expr =
    Expr.Multiply(
      Expr.Add(Expr.Literal(2), Expr.Literal(3)),
      Expr.Literal(4)
    )

  println(ExprModule.evaluate(expr))
  println(ExprModule.show(expr))

  // Task 9 - svolto da solo
  println("\nTask 9")

  object Optionals:

    enum OptionalInt:
      case Just(value: Int)
      case Empty()

    object OptionalInt:

      def isEmpty(opt: OptionalInt): Boolean = opt match
        case Empty() => true
        case _       => false

      def orElse(opt: OptionalInt, orElse: Int): Int = opt match
        case Just(a) => a
        case _       => orElse

      def mapInt(opt: OptionalInt)(mapper: Int => Int): OptionalInt = opt match
        case Just(value) => Just(mapper(value))
        case Empty()     => Empty()

      def filter(opt: OptionalInt)(predicate: Int => Boolean): OptionalInt = opt match
        case Just(value) if predicate(value) => Just(value)
        case _                               => Empty()

  import Optionals.*
  import OptionalInt.*

  val s1: OptionalInt = Just(1)
  val s2: OptionalInt = Empty()

  println(s1)
  println(isEmpty(s1))
  println(orElse(s1, 0))
  println(orElse(s2, 0))
  println(mapInt(Just(5))(_ + 1))
  println(mapInt(Empty())(_ + 1))
  println(filter(Just(5))(_ > 2))
  println(filter(Just(5))(_ > 8))
  println(filter(Empty())(_ > 2))

  val xs = List(Just(5), Empty(), Just(1))
  println(xs.map(filter(_)(_ > 2)))