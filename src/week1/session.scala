package week1

object session extends App{
  1+2
  def abs(x: Double) = if(x< 0) -x else x 

  def sqrt(x: Double) ={ 
      def sqrtIter(guess : Double) : Double = 
        if(isGoodEnough(guess)) guess
        else sqrtIter(improve(guess))
        
      def isGoodEnough(guess : Double) =
        abs(guess * guess - x)/x < 0.001
        
      def improve(guess : Double) = 
        (guess + x / guess)/2
    
      sqrtIter(1.0) 
  }
  val res = sqrt(2)
  println(res)
  val res2 = sqrt(4)
  println(res2)
  val res3 = sqrt(1e-6)
  println(res3)
  val res4 = sqrt(1e90)
  println(res4)
}

