package week4.typesAndPatternMatching

object ListObject {
  //ListObject(1,2) = ListObject.apply(1,2)
  def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, new Nil))
  def apply[T](x1: T): List[T] = new Cons(x1, new Nil)
  def apply[T]() = new Nil
  
}

object mylist extends App {
  val l = ListObject(1)
  println(l.toString())
}