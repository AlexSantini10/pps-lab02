package part5

// overall module
object Optionals extends App:

  // type "public" definition, exposing structure
  enum OptionalInt:
    case Just(value: Int)
    case Empty()

  // operations (/algorithms)
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