package week4.typesAndPatternMatching

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

//Variance with trait List[+T]
//class Nil extends List[Nothing] {
//  def isEmpty: Boolean = true
//  def head : Nothing = throw new NoSuchElementException("Nil.head")
//  def tail : Nothing = throw new NoSuchElementException("Nil.tail")
//}