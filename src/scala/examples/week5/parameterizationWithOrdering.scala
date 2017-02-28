package week5
import math.Ordering

//Ordering to specify type and use of implicit to escape mentioning ordering
object parameterizationWithOrdering extends App {
  
    // using pair or tuple
      def merge2[T](xs: List[T], ys: List[T])(implicit ord: Ordering[T]) : List[T] = (xs,ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) => {
          if(ord.lt(x , y)) x :: merge2(xs1, ys)
          else y :: merge2(xs, ys1)
        }
      }
    
    def msort[T](xs : List[T])(implicit ord: Ordering[T]) : List[T] = {
      val n =xs.length/2
      if(n==0) xs
      else{
        def merge(xs: List[T], ys: List[T])(implicit ord: Ordering[T]) : List[T] = merge2(xs, ys)
        val (fst, snd) = xs splitAt n
        merge(msort(fst), msort(snd))
      }
    }
    
    
    //pairs and Tuples like map or key value pair
    val pair = ("answer", 42)
    val fruits = List("apple", "pineapple", "orange", "banana")
    
    val num = List(2, -4, 5, 7, 1)
    println(msort(num))
    println(msort(fruits))

}