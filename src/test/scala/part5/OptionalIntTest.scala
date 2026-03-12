package part5

import org.junit.*
import org.junit.Assert.*
import Optionals.*

class OptionalIntTest:

  @Test def emptyOptionalShouldBeEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertTrue(OptionalInt.isEmpty(empty))

  @Test def nonEmptyOptionalShouldNotBeEmpty(): Unit =
    val nonEmpty = OptionalInt.Just(0)
    assertFalse(OptionalInt.isEmpty(nonEmpty))

  @Test def orElseShouldReturnDefaultWhenEmpty(): Unit =
    val nonEmpty = OptionalInt.Just(0)
    assertEquals(0, OptionalInt.orElse(nonEmpty, 1))

  @Test def orElseShouldReturnValueWhenNonEmpty(): Unit =
    val empty = OptionalInt.Empty()
    assertEquals(1, OptionalInt.orElse(empty, 1))

  /** Task 5: do test for map **/

  @Test def mapShouldTransformValueWhenPresent(): Unit =
    val value = OptionalInt.Just(5)
    val result = OptionalInt.mapInt(value)(_ + 1)
    assertEquals(OptionalInt.Just(6), result)

  @Test def mapShouldReturnEmptyWhenInputIsEmpty(): Unit =
    val empty = OptionalInt.Empty()
    val result = OptionalInt.mapInt(empty)(_ + 1)
    assertEquals(OptionalInt.Empty(), result)

  /** Task 5: do test for filter **/

  @Test def filterShouldKeepValueWhenPredicateIsTrue(): Unit =
    val value = OptionalInt.Just(5)
    val result = OptionalInt.filter(value)(_ > 2)
    assertEquals(OptionalInt.Just(5), result)

  @Test def filterShouldRemoveValueWhenPredicateIsFalse(): Unit =
    val value = OptionalInt.Just(5)
    val result = OptionalInt.filter(value)(_ > 8)
    assertEquals(OptionalInt.Empty(), result)

  @Test def filterShouldReturnEmptyWhenInputIsEmpty(): Unit =
    val empty = OptionalInt.Empty()
    val result = OptionalInt.filter(empty)(_ > 2)
    assertEquals(OptionalInt.Empty(), result)