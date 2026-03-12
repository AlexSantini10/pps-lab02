package it.unibo.pps.u02

enum Expr:
  case Literal(value: Int)
  case Add(left: Expr, right: Expr)
  case Multiply(left: Expr, right: Expr)

object ExprModule:

  def evaluate(expr: Expr): Int = expr match
    case Expr.Literal(value) => value
    case Expr.Add(left, right) =>
      evaluate(left) + evaluate(right)
    case Expr.Multiply(left, right) =>
      evaluate(left) * evaluate(right)

  def show(expr: Expr): String = expr match
    case Expr.Literal(value) => value.toString
    case Expr.Add(left, right) =>
      "(" + show(left) + " + " + show(right) + ")"
    case Expr.Multiply(left, right) =>
      "(" + show(left) + " * " + show(right) + ")"