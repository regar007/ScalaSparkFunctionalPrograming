package week3

object rationals extends App{
  val rat = new Rational(1,2)
  
  def addRationals(first: Rational, second: Rational): Rational = {
    new Rational(
      first.numr * second.deno + second.numr * first.deno,
      first.deno * second.deno
    )
  }
  
  def makeStr(r: Rational) = r.numr +"/"+ r.deno
  
  val sum = makeStr(addRationals(new Rational(1,2), new Rational(2,3)))
  println(sum)
  println(rat.numr, rat.deno)
  
  val x = new Rational(1,3)
  val y = new Rational(5,7)
  val z = new Rational(3,2)
  val sub = x.sub(y)
  val less = x.less(y)
  val max = x.max(y)
  
  println("sub : "+ sub+ ": "+ less+ ": "+ max)
}