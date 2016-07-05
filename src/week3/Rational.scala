package week3

class Rational(x: Int, y: Int) {
     require(y !=0, "denomator should not be zero")
     
     def this(x: Int) = this(x, 1)
  
     private def gcd(a: Int, b: Int) : Int = if(b == 0) a else gcd(b, a % b) 
     private val g = gcd(x, y) 
     def numr = x/g
     def deno = y/g
     
     def less(that: Rational) = numr * that.deno < that.numr * deno
     
     def max(that: Rational) = if(this.less(that)) that else this
     
     def add(that: Rational): Rational = {
       new Rational(
           numr * that.deno + that.numr * deno, 
           deno * that.deno 
       )
     }
     
     def neg : Rational = new Rational(- numr, deno)
     
     def sub(that: Rational): Rational = add(that.neg)

     //other way with defining with operator symbols
     def < (that: Rational) = numr * that.deno < that.numr * deno
     
     def _max (that: Rational) = if(this < that) that else this
     
     def + (that: Rational): Rational = {
       new Rational(
           numr * that.deno + that.numr * deno, 
           deno * that.deno 
       )
     }
     
     def unary_- : Rational = new Rational(- numr, deno)
     
     def - (that: Rational): Rational = this + -that
     //end

     override def toString() = if (deno < 0) (-numr + "/"+ -deno) else (numr + "/"+ deno)
}