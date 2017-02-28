package week5

object parameterization extends App {
  
    // using pair or tuple
      def merge2[T](xs: List[T], ys: List[T])(lt: (T, T) => Boolean) : List[T] = (xs,ys) match {
        case (Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) => {
          if(lt(x , y)) x :: merge2(xs1, ys)(lt)
          else y :: merge2(xs, ys1)(lt)
        }
      }
    
    def msort[T](xs : List[T])(lt: (T,T) => Boolean) : List[T] = {
      val n =xs.length/2
      if(n==0) xs
      else{
        def merge(xs: List[T], ys: List[T])(lt : (T, T) => Boolean) : List[T] = merge2(xs, ys)(lt)
        val (fst, snd) = xs splitAt n
        merge(msort(fst)(lt), msort(snd)(lt))(lt)
      }
    }
    
    
    //pairs and Tuples like map or key value pair
    val pair = ("answer", 42)
    val fruits = List("apple", "pineapple", "orange", "banana")
    
    val num = List(2, -4, 5, 7, 1)
    println(msort(num)((x, y) => x < y))
    println(msort(fruits)((x, y) => x.compareTo(y) < 0))

}