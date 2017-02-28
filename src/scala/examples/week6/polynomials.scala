package week6

object polynomials extends App{
  class Poly(val terms0: Map[Int, Double]){
    def this(bindings: (Int, Double)*) = this(bindings.toMap) // * represent a repeated parameter 
    val terms = terms0.withDefaultValue (0.0)
    
    //def + (other: Poly) = new Poly(terms ++ other.terms map adjust)
    
    //with foldLeft
    def + (other: Poly) = new Poly((other.terms foldLeft terms)(addTerm))
    
    def addTerm(terms: Map[Int, Double], term: (Int,Double)) : Map[Int, Double] = {
      val (exp, coeff) = term
      terms + (exp -> (coeff + terms(exp)))
    }
    
    def adjust(term: (Int, Double)) : (Int, Double) = {
      val (exp, coeff) = term
      
     // when using 'withDefaultValue' 
      exp -> (coeff+ terms(exp))

//    //if we dont use 'withDefaultValue'  
//      terms get exp match {
//        case Some(coeff1) => exp -> (coeff + coeff1)
//        case None => exp -> coeff
//      }
    }
    override def toString = (for((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
  }
  
  //p1 = 2x + 4x^3 + 6.2x^5
  //p2 = 3 + 7x^3
  val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
  val p3 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2)
  val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0))
  
  println(p1+p2+p3)
  println(p1.terms(1))
}