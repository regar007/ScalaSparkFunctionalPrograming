package week3

object fixedPoint extends App{
  val tolerance = 0.001
  def isGoodEnough(x: Double, y: Double ) = {
    scala.math.abs((x -y)/x)/x < tolerance
  }
  def fixedpoint(f: Double => Double)(firstguess: Double): Double ={
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if(isGoodEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstguess)
  }
  
  def avgdamp(f: Double => Double)(x: Double) = (x + f(x))/2
  
 // def sqrt(x: Double) = fixedpoint(y => (y + x/y)/2)(1.0)
  def sqrt(x: Double) = fixedpoint(avgdamp(y => x/y))(1.0)

  val fp = fixedpoint(x => 1 + x/2)(1)
  val sr = sqrt(2)
  println(fp)
  println(sr)
}