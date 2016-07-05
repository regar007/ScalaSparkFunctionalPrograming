package week3

object Currying extends App{
  def mapReduce(f: Int => Int, combine : (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if(a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a+1, b))
  }
  def productMapReduce(f: Int => Int)(a: Int, b:Int): Int = mapReduce(x => x, (x,y) => x * y, 1)(a, b)
  
  def product(f: Int => Int)(a: Int, b:Int): Int = {
    if(a > b) 1
    else f(a) * product(f)(a+1, b)
  }
 val pro = product(x => x)(3, 4)
 
 val fac = product(x => x)(1, 5)
 val proMapRedu = productMapReduce(x => x)(1, 5)
 println(pro)
 println(fac)
 println(proMapRedu)
}