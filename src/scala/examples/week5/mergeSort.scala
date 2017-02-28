package week5

//more effcient than insertion sort
//The idea behind merge sort is as follows: if a list consists of zero or one elements, 
//it's obviously already sorted so there's nothing to do. Otherwise, we separate the lists into two sub lists 
//each containing around half of the elements of the original list. An easy way to do that would be to simply 
//take the first n elements of the list and then the second n element of the lists if the lengths of the list is 2n. 
//Once we have the two sub lists we sort them each in turn and then we merge the two sorted sub lists into a single sorted list. 
//To see the algorithm in code, look at this function here. So we would have a function msort for merge sort. 
//It takes a list of Ints for the moment we restrict ourselves to lists of a single type, 
//and it returns a list of Ints The first thing is the splitting, so we take the length of the list divided by two, that's our n. 
//If n is zero than, than the original length was zero or one, because division truncates towards zero. 
//In both of these cases, the list is already sorted so we can simply return it. If n is not zero, 
//Then what we do is we split the list at point N so we'll get to split that function in a moment. 
//It returns essentially the first half of the list and the second half of the list. 
//Then we sort both of these halfs with the recursive call to msort and finally we merge the two sorted lists. 
//The definition of merge is here, is a function that takes two lists of Ints and we have left out its implementation so far.
object mergeSort extends App {
  
  def merge1(xs: List[Int], ys: List[Int]) : List[Int] = xs match {
        case Nil => ys
        case x :: xs1 => ys match {
          case Nil => xs
          case y :: ys1 => {
            if(x < y) x :: merge1(xs1, ys)
            else y :: merge1(xs, ys1)
          }
        }
    }
  
    // using pair or tuple
    def merge2(xs: List[Int], ys: List[Int]) : List[Int] = (xs,ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) => {
        if(x < y) x :: merge2(xs1, ys)
        else y :: merge2(xs, ys1)
      }
    }
  
  def msort(xs : List[Int]) : List[Int] = {
    val n =xs.length/2
    if(n==0) xs
    else{
      def merge(xs: List[Int], ys: List[Int]) : List[Int] = merge2(xs, ys)
      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }
  
  
  //pairs and Tuples like map or key value pair
  val pair = ("answer", 42)
  
  val num = List(2, -4, 5, 7, 1)
  println(msort(num))
  
  
  
}