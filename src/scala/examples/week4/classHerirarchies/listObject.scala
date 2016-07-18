package week4.classHerirarchies

object listObject extends App {
  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])
  
  def nth[T](n: Int, xs: List[T]) : T = {
    if(xs.isEmpty)  throw new IndexOutOfBoundsException()
    else if(n==0) xs.head
    else nth(n-1, xs.tail) //reduce one and send tail which is the next list item
  }
  
  val list = singleton[Int](1)
  val list2 = new Cons(1, new Cons(2, new Cons(3, new Nil[Int])))
  
  val n = nth(0, list2)
  println(list.head+", "+ list2+ ", "+ n)
}