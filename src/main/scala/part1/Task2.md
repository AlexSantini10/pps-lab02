# Lab02 - REPL experiments

Experiments done in the Scala REPL (`sbt console`) to explore functions, currying and partial application.

## Currying

Code tested in the REPL:

```scala
def mult(x: Double, y: Double): Double = x * y
def multCurried(x: Double)(y: Double): Double = x * y

mult(3,4)
mult(2,5)
multCurried(3)(4)
multCurried(2)(5)
```

Both versions produce the same result, but the curried one takes parameters in two argument lists.

## Partial application

```scala
val multiplyBy3 = multCurried(3)

multiplyBy3(5)
multiplyBy3(10)
multiplyBy3(0)
```

`multCurried(3)` returns a new function with the first parameter fixed.

## Variation with division

```scala
def divide(x: Double, y: Double): Double = x / y
def divideCurried(x: Double)(y: Double): Double = x / y

divide(10,2)
divideCurried(10)(2)
divide(-10,2)
divide(10,0)
```

The behavior is similar to `mult` and `multCurried`, but with division instead of multiplication.

## Observations

Curried functions allow partial application, so they can return a new function when only part of the parameters is provided.

Changing the operation does not change the general structure of the function.

With `Double`, division by zero does not necessarily raise an exception in the REPL, so it is useful to test this case explicitly.
