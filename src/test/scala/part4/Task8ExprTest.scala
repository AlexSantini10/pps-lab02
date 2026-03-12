package it.unibo.pps.u02

import org.junit.Assert.assertEquals
import org.junit.Test

class Task8ExprTest {

  @Test
  def testEvaluateLiteral(): Unit = {
    val expr = Expr.Literal(5)

    val result = ExprModule.evaluate(expr)

    assertEquals(5, result)
  }

  @Test
  def testEvaluateAddition(): Unit = {
    val expr = Expr.Add(Expr.Literal(2), Expr.Literal(3))

    val result = ExprModule.evaluate(expr)

    assertEquals(5, result)
  }

  @Test
  def testEvaluateMultiplication(): Unit = {
    val expr = Expr.Multiply(Expr.Literal(4), Expr.Literal(3))

    val result = ExprModule.evaluate(expr)

    assertEquals(12, result)
  }

  @Test
  def testEvaluateNestedExpression(): Unit = {
    val expr = Expr.Multiply(
      Expr.Add(Expr.Literal(2), Expr.Literal(3)),
      Expr.Literal(4)
    )

    val result = ExprModule.evaluate(expr)

    assertEquals(20, result)
  }

  @Test
  def testShowLiteral(): Unit = {
    val expr = Expr.Literal(7)

    val result = ExprModule.show(expr)

    assertEquals("7", result)
  }

  @Test
  def testShowAddition(): Unit = {
    val expr = Expr.Add(Expr.Literal(2), Expr.Literal(3))

    val result = ExprModule.show(expr)

    assertEquals("(2 + 3)", result)
  }

  @Test
  def testShowMultiplication(): Unit = {
    val expr = Expr.Multiply(Expr.Literal(4), Expr.Literal(5))

    val result = ExprModule.show(expr)

    assertEquals("(4 * 5)", result)
  }

  @Test
  def testShowNestedExpression(): Unit = {
    val expr = Expr.Multiply(
      Expr.Add(Expr.Literal(2), Expr.Literal(3)),
      Expr.Literal(4)
    )

    val result = ExprModule.show(expr)

    assertEquals("((2 + 3) * 4)", result)
  }
}