package week5

object higherOrderListFunction extends App{
  def squareList(xs: List[Int]): List[Int] = xs match {
    case Nil => xs
    case y :: ys => (y * y)  :: squareList(ys)
  }
  
  def squareListMap(xs: List[Int]): List[Int] = xs map (x => x * x)
  
  //positive elements 
  def posElems(xs: List[Int]): List[Int] = xs match {
    case Nil => xs
    case y :: ys => if(y > 0) y * y :: posElems(ys) else posElems(ys)
  }
  
    
  val list = List(-1, 2, 3, -4)
  
  println(posElems(list))
}


